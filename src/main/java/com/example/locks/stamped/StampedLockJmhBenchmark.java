package com.example.locks.stamped;

import com.example.locks.ReadWriteOperationMix;
import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class StampedLockJmhBenchmark {

    @State(Scope.Benchmark)
    public static class SharedState {
        private final ReadWriteTestCandidate candidate = new StampedLockCandidate();
    }

    @Benchmark
    public int mixedReadWrite(SharedState shared, ReadWriteOperationMix mix) {
        if (mix.nextIsWrite()) {
            shared.candidate.write();
            return 0;
        }
        return shared.candidate.read();
    }

    private static final class StampedLockCandidate implements ReadWriteTestCandidate {
        private final StampedLock lock = new StampedLock();
        private int first;
        private int second;

        @Override
        public int read() {
            long stamp = lock.tryOptimisticRead();
            int observedFirst = first;
            int observedSecond = second;
            if (lock.validate(stamp)) {
                return observedFirst + observedSecond;
            }

            stamp = lock.readLock();
            try {
                return first + second;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        @Override
        public void write() {
            long stamp = lock.writeLock();
            try {
                first++;
                second++;
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }
}
