package com.example.locks.simple_reentrant;

import com.example.locks.ReadWriteTestCandidate;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

import java.util.concurrent.locks.ReentrantLock;

@JCStressTest
@Outcome(id = "0", expect = Expect.ACCEPTABLE, desc = "Read completed before the write")
@Outcome(id = "11", expect = Expect.ACCEPTABLE, desc = "Read completed after the write")
@Outcome(expect = Expect.ACCEPTABLE_INTERESTING, desc = "Read observed a partial write")
@State
public class ReentrantLockJcstressTest {
    private final ReadWriteTestCandidate candidate = new ReentrantLockCandidate();

    @Actor
    public void writer() {
        candidate.write();
    }

    @Actor
    public void reader(I_Result result) {
        result.r1 = candidate.read();
    }

    private static final class ReentrantLockCandidate implements ReadWriteTestCandidate {
        private final ReentrantLock lock = new ReentrantLock();
        private int first;
        private int second;

        @Override
        public int read() {
            lock.lock();
            try {
                return first * 10 + second;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void write() {
            lock.lock();
            try {
                first = 1;
                second = 1;
            } finally {
                lock.unlock();
            }
        }
    }
}
