package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

/** Plain accesses allow the store/load Dekker outcome (0, 0). */
@JCStressTest
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Both writes observed")
@Outcome(id = {"0, 1", "1, 0"}, expect = Expect.ACCEPTABLE, desc = "One write observed")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE_INTERESTING,
        desc = "Both reads can miss the other actor's plain write")
@State
public class PlainDekkerTest {
    int x;
    int y;

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
