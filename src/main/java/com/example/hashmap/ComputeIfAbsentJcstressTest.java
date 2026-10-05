package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Actor 1 computed the value")
@Outcome(id = "2, 2", expect = Expect.ACCEPTABLE, desc = "Actor 2 computed the value")
@Outcome(id = {"0, 1", "1, 0", "1, 2", "2, 1", "0, 2", "2, 0"},
        expect = Expect.ACCEPTABLE_INTERESTING, desc = "Unexpected result")
@State
public class ComputeIfAbsentJcstressTest {
    // Switch to ConcurrentHashMap to test the concurrent implementation.
    private final Map<String, Integer> map = new HashMap<>();

    @Actor
    public void actor1(II_Result result) {
        result.r1 = map.computeIfAbsent("key", key -> 1);
    }

    @Actor
    public void actor2(II_Result result) {
        result.r2 = map.computeIfAbsent("key", key -> 2);
    }
}
