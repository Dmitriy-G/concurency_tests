package com.example.counter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class CounterJmhBenchmark {
    private final AtomicInteger atomic = new AtomicInteger();
    private final Counters.Counter synchronizedCounter = new Counters.Synchronized();
    private final Counters.Counter casCounter = new Counters.CasWithAtomicUpdaterWithVolatile();

    @Benchmark
    public int atomic() { return atomic.getAndIncrement(); }

    @Benchmark
    public int synchronizedCounter() { return synchronizedCounter.getAndIncrement(); }

    @Benchmark
    public int casCounter() { return casCounter.getAndIncrement(); }
}
