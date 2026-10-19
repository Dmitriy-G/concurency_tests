package com.example.locks.sync;

import com.example.locks.ReadWriteTestCandidate;
import com.example.locks.ReadWriteOperationMix;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SyncPessimisticLockJmhBenchmark {

    @State(Scope.Benchmark)
    public static class SharedState {
        private final ReadWriteTestCandidate candidate = new SynchronizedCandidate();
    }

    @Benchmark
    public int mixedReadWrite(SharedState shared, ReadWriteOperationMix mix) {
        if (mix.nextIsWrite()) {
            shared.candidate.write();
            return 0;
        }
        return shared.candidate.read();
    }

    private static final class SynchronizedCandidate implements ReadWriteTestCandidate {
        private int first;
        private int second;

        @Override
        public synchronized int read() {
            return first + second;
        }

        @Override
        public synchronized void write() {
            first++;
            second++;
        }
    }
}
