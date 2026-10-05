package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/** A plain flag does not safely publish the preceding plain data write. */
@JCStressTest
@Outcome(id = "-1", expect = Expect.ACCEPTABLE, desc = "Writer not observed")
@Outcome(id = "5", expect = Expect.ACCEPTABLE, desc = "Published value observed")
@Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Flag seen without data")
@State
public class PlainPublicationTest {
    int value;
    boolean ready;

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
