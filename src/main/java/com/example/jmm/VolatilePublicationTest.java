package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/** Seeing the volatile flag establishes happens-before for the data write. */
@JCStressTest
@Outcome(id = "-1", expect = Expect.ACCEPTABLE, desc = "Writer not observed")
@Outcome(id = "5", expect = Expect.ACCEPTABLE, desc = "Published value observed")
@Outcome(id = "0", expect = Expect.FORBIDDEN, desc = "Flag seen without data")
@State
public class VolatilePublicationTest {
    int value;
    volatile boolean ready;

    @Actor
    public void writer() {
        value = 5;
        ready = true;
    }

    @Actor
    public void reader(I_Result result) {
        result.r1 = ready ? value : -1;
    }
}
