package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

/** A single actor must behave as though its operations ran in program order. */
@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Serial result")
@Outcome(expect = Expect.FORBIDDEN, desc = "Would change single-thread behavior")
@State
public class SingleActorOrderTest {
    int x;
    int y;

    @Actor
    public void actor1(II_Result result) {
        x = 1;
        result.r1 = x;
        y = 1;
        result.r2 = y;
    }
}
