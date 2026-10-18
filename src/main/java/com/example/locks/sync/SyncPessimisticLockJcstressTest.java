package com.example.locks.sync;

import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Read completed before the write")
@Outcome(id = "11", expect = Expect.ACCEPTABLE, desc = "Read completed after the write")
@Outcome(expect = Expect.ACCEPTABLE_INTERESTING, desc = "Read observed a partial write")
@State
public class SyncPessimisticLockJcstressTest {
    private final ReadWriteTestCandidate candidate = new SynchronizedCandidate();

    @Actor
    public void writer() {
        candidate.write();
    }

    @Actor
    public void reader(I_Result result) {
        result.r1 = candidate.read();
    }

    private static final class SynchronizedCandidate implements ReadWriteTestCandidate {
        private int first;
        private int second;

        @Override
        public synchronized int read() {
            return first * 10 + second;
        }

        @Override
        public synchronized void write() {
            first = 1;
            second = 1;
        }
    }
}
