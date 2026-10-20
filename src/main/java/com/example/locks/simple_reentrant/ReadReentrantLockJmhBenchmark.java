package com.example.locks.simple_reentrant;

import com.example.locks.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ReadReentrantLockJmhBenchmark {

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
        private final ReentrantLock lock = new ReentrantLock();
        // private final BlackHole100Workload workload = new BlackHole100Workload();
        // private final BlackHole5KWorkload workload = new BlackHole5KWorkload();
        // private final BlackHole10KWorkload workload = new BlackHole10KWorkload();
        private final BlackHole50KWorkload workload = new BlackHole50KWorkload();

        @Override
        public int read() {
            lock.lock();
            try {
                return workload.sum();
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void write() {
            lock.lock();
            try {
                workload.incrementOne();
            } finally {
                lock.unlock();
            }
        }
    }
}
