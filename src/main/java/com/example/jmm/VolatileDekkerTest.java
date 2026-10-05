package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

/** Volatile accesses rule out the (0, 0) outcome of the plain Dekker test. */
@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Both writes visible")
@Outcome(id = {"0, 1", "1, 0"}, expect = Expect.ACCEPTABLE, desc = "One write visible")
@Outcome(id = "0, 0", expect = Expect.FORBIDDEN, desc = "Violates volatile ordering")
@State
public class VolatileDekkerTest {
    volatile int x;
    volatile int y;

    @Actor
    public void actor1(II_Result result) {
        x = 1;
        result.r1 = y;
    }

    @Actor
    public void actor2(II_Result result) {
        y = 1;
        result.r2 = x;
    }
}
