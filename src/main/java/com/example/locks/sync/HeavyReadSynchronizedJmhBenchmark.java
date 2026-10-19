package com.example.locks.sync;

import com.example.locks.LongArrayWorkload;
import com.example.locks.ReadWriteOperationMix;
import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class HeavyReadSynchronizedJmhBenchmark {

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
        private final LongArrayWorkload workload = new LongArrayWorkload();

        @Override
        public synchronized int read() {
            return workload.sum();
        }

        @Override
        public synchronized void write() {
            workload.incrementOne();
        }
    }
}
