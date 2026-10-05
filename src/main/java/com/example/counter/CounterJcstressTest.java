package com.example.counter;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "Actor 1 incremented first")
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Actor 2 incremented first")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Lost increment")
@State
public class CounterJcstressTest {
    private final Counters.Counter counter = new Counters.CasWithAtomicUpdaterWithVolatile();

    @Actor
    public void actor1(II_Result result) {
        result.r1 = counter.getAndIncrement();
    }

    @Actor
    public void actor2(II_Result result) {
        result.r2 = counter.getAndIncrement();
    }
}
