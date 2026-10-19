package com.example.locks.read_write_reentrant;

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

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ReentrantReadWriteLockJmhBenchmark {

    @State(Scope.Benchmark)
    public static class SharedState {
        private final ReadWriteTestCandidate candidate = new ReadWriteLockCandidate();
    }

    @Benchmark
    public int mixedReadWrite(SharedState shared, ReadWriteOperationMix mix) {
        if (mix.nextIsWrite()) {
            shared.candidate.write();
            return 0;
        }
        return shared.candidate.read();
    }

    private static final class ReadWriteLockCandidate implements ReadWriteTestCandidate {
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        private int first;
        private int second;

        @Override
        public int read() {
            lock.readLock().lock();
            try {
                return first + second;
            } finally {
                lock.readLock().unlock();
            }
        }

        @Override
        public void write() {
            lock.writeLock().lock();
            try {
                first++;
                second++;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
