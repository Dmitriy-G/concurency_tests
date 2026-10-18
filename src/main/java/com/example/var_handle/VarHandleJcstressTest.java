package com.example.var_handle;

import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Reader did not observe the published write")
@Outcome(id = "11", expect = Expect.ACCEPTABLE, desc = "Reader observed both values after publication")
@Outcome(expect = Expect.FORBIDDEN, desc = "Reader observed a partial write after publication")
@State
public class VarHandleJcstressTest {

    private final ReadWriteTestCandidate candidate = new VarHandleCandidate();

    @Actor
    public void writer() {
        candidate.write();
    }

    @Actor
    public void reader(I_Result result) {
        result.r1 = candidate.read();
    }

    private static final class VarHandleCandidate implements ReadWriteTestCandidate {

        private static final VarHandle PUBLISHED;

        static {
            try {
                PUBLISHED = MethodHandles.lookup().findVarHandle(VarHandleCandidate.class, "published", int.class);
            } catch (ReflectiveOperationException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        private int first;
        private int second;
        private int published;

        @Override
        public int read() {
            if ((int) PUBLISHED.getAcquire(this) == 0) {
                return 0;
            }
            return first * 10 + second;
        }

        @Override
        public void write() {
            first = 1;
            second = 1;
            PUBLISHED.setRelease(this, 1);
        }
    }
}
