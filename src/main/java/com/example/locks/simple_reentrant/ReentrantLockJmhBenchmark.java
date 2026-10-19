package com.example.locks.simple_reentrant;

import com.example.locks.ReadWriteOperationMix;
import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ReentrantLockJmhBenchmark {

    @State(Scope.Benchmark)
    public static class SharedState {
        private final ReadWriteTestCandidate candidate = new ReentrantLockCandidate();
    }

    @Benchmark
    public int mixedReadWrite(SharedState shared, ReadWriteOperationMix mix) {
        if (mix.nextIsWrite()) {
            shared.candidate.write();
            return 0;
        }
        return shared.candidate.read();
    }

    private static final class ReentrantLockCandidate implements ReadWriteTestCandidate {
        private final ReentrantLock lock = new ReentrantLock();
        private int first;
        private int second;

        @Override
        public int read() {
            lock.lock();
            try {
                return first + second;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void write() {
            lock.lock();
            try {
                first++;
                second++;
            } finally {
                lock.unlock();
            }
        }
    }
}
