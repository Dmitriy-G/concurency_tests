package com.example.locks.read_write_reentrant;

import com.example.locks.MediumWorkload;
import com.example.locks.ReadWriteOperationMix;
import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class HeavyReadWriteLockJmhBenchmark {

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
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        private final MediumWorkload workload = new MediumWorkload();

        @Override
        public int read() {
            lock.readLock().lock();
            try {
                return workload.sum();
            } finally {
                lock.readLock().unlock();
            }
        }

        @Override
        public void write() {
            lock.writeLock().lock();
            try {
                workload.incrementOne();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
