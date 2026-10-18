package com.example.locks.stamped;

import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

import java.util.concurrent.locks.StampedLock;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Read completed before the write")
@Outcome(id = "11", expect = Expect.ACCEPTABLE, desc = "Read completed after the write")
@Outcome(expect = Expect.ACCEPTABLE_INTERESTING, desc = "Read observed a partial write")
@State
public class StampedLockJcstressTest {
    private final ReadWriteTestCandidate candidate = new StampedLockCandidate();

    @Actor
    public void writer() {
        candidate.write();
    }

    @Actor
    public void reader(I_Result result) {
        result.r1 = candidate.read();
    }

    private static final class StampedLockCandidate implements ReadWriteTestCandidate {
        private final StampedLock lock = new StampedLock();
        private int first;
        private int second;

        @Override
        public int read() {
            long stamp = lock.tryOptimisticRead();
            int observedFirst = first;
            int observedSecond = second;
            if (!lock.validate(stamp)) {
                return observedFirst * 10 + observedSecond;
            }

            stamp = lock.readLock();

            try {
                return first * 10 + second;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        @Override
        public void write() {
            long stamp = lock.writeLock();
            try {
                first = 1;
                second = 1;
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }
}
