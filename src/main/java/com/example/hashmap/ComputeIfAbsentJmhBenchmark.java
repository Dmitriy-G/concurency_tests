package com.example.hashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ComputeIfAbsentJmhBenchmark {
    private final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    @Setup
    public void setup() {
        map.put("key", 1);
    }

    @Benchmark
    public Integer existingKey() {
        return map.computeIfAbsent("key", key -> 2);
    }
}
