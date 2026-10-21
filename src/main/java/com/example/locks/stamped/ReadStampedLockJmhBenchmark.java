package com.example.locks.stamped;

import com.example.locks.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ReadStampedLockJmhBenchmark {

    @State(Scope.Benchmark)
    public static class SharedState {
        private final ReadWriteTestCandidate candidate = new Candidate();
    }

    @Benchmark
    public int mixedReadWrite(SharedState shared, ReadWriteOperationMix mix) {
        if (mix.nextIsWrite()) {
            shared.candidate.write();
            return 0;
        }
        return shared.candidate.read();
    }

    private static final class Candidate implements ReadWriteTestCandidate {
        private final StampedLock lock = new StampedLock();
        private BlackHoleWorkload workload = new BlackHoleWorkload();

        @Override
        public int read() {
            long stamp = lock.tryOptimisticRead();
            int result = workload.sum();
            if (lock.validate(stamp)) {
                return result;
            }

            stamp = lock.readLock();
            try {
                return workload.sum();
            } finally {
                lock.unlockRead(stamp);
            }
        }

        @Override
        public void write() {
            long stamp = lock.writeLock();
            try {
                workload.incrementOne();
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }
}
