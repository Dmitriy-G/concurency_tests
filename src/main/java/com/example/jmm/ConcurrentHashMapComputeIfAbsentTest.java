package com.example.jmm;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.III_Result;
import org.openjdk.jcstress.infra.results.II_Result;

/** Two concurrent calls for one key must share one computed value. */
@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Actor 1 computed the value")
@Outcome(id = "2, 2", expect = Expect.ACCEPTABLE, desc = "Actor 2 computed the value")
@Outcome(id = {"0, 1", "1, 0", "1, 2", "2, 1", "0, 2", "2, 0"},expect = Expect.ACCEPTABLE_INTERESTING, desc = "Key rewriting")
@State
public class ConcurrentHashMapComputeIfAbsentTest {
//    private final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    private final HashMap<String, Integer> map = new HashMap<>();

    @Actor
    public void actor1(II_Result result) {
        result.r1 = map.computeIfAbsent("key", key -> 1);
    }

    @Actor
    public void actor2(II_Result result) {
        result.r2 = map.computeIfAbsent("key", key -> 2);
    }
}
