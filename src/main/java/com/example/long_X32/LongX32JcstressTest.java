package com.example.long_X32;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.J_Result;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Actor 1 computed the value")
@Outcome(id = "-1", expect = Expect.ACCEPTABLE, desc = "Actor 2 computed the value")
@Outcome(expect = Expect.ACCEPTABLE_INTERESTING, desc = "Unexpected result")
@State
public class LongX32JcstressTest {

    long v;

    @Actor
    public void writer() {
        v = 0xFFFFFFFF_FFFFFFFFL;
    }

    @Actor
    public void reader(J_Result r) {
        r.r1 = v;
    }
}
