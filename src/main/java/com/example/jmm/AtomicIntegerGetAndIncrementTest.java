package com.example.jmm;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Here are counters threadsafe tests
 *
 * Good threadsafe approaches
 *
 * AtomicInteger - OK, this is plain java atomic  (total test time ?)
 * SyncCustomCounter - OK, this is plain slow synchronized (total test time ?)
 * CasWithAtomicUpdaterWithVolatileCustomCounter - OK, this is CAS with volatile
 * field and atomic check with increment (total test time ?)
 *
 * Bad approaches
 *
 * PlainCustomCounter - bad, no any thread safe
 * VolatileCustomCounter - bad, volatile solve visibility problem, but not atomic
 * CasWithoutVolatileCustomCounter - bad, this is CAS, but without solving visibility and atomic problems
 * CasWithVolatileCustomCounter - bad, atomic problem still exist
 * CasWithAtomicUpdaterWithoutVolatileCustomCounter - bad, visibility problem exist. AtomicIntegerFieldUpdater check it ar runtime and throw exception
 *
 *
 *
 */
@JCStressTest
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "Actor 1 incremented first")
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Actor 2 incremented first")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Counter rewrote by another thread")
@State
public class AtomicIntegerGetAndIncrementTest {
//    private final AtomicInteger counter = new AtomicInteger();

    private final CasWithAtomicUpdaterWithVolatileCustomCounter counter = new CasWithAtomicUpdaterWithVolatileCustomCounter();

    @Actor
    public void actor1(II_Result result) {
        result.r1 = counter.getAndIncrement();
    }

    @Actor
    public void actor2(II_Result result) {
        result.r2 = counter.getAndIncrement();
    }


    private static class PlainCustomCounter {

        private int i;

        protected int getAndIncrement() {
            return i++;
        }
    }

    private static class SyncCustomCounter {

        private int i;

        protected synchronized int getAndIncrement() {
            return i++;
        }
    }

    private static class VolatileCustomCounter {

        private volatile int i;

        protected int getAndIncrement() {
            return i++;
        }
    }

    private static class CasWithoutVolatileCustomCounter {

        private int i;

        protected int getAndIncrement() {

            int old;
            int temp;

            while (true) {
                old = i;
                temp = i + 1;
                if (old == i) {
                    i = temp;
                    break;
                }
            }

            return old;
        }
    }

    private static class CasWithVolatileCustomCounter {

        private volatile int i;

        protected int getAndIncrement() {

            int old;
            int temp;

            while (true) {
                old = i;
                temp = i + 1;
                if (old == i) {
                    i = temp;
                    break;
                }
            }

            return old;
        }
    }

    // Incorrect, AtomicIntegerFieldUpdater has checking and throw IllegalArgumentException: Must be volatile type
    private static class CasWithAtomicUpdaterWithoutVolatileCustomCounter {

        private static final AtomicIntegerFieldUpdater<CasWithAtomicUpdaterWithoutVolatileCustomCounter> UPDATER =
                AtomicIntegerFieldUpdater.newUpdater(CasWithAtomicUpdaterWithoutVolatileCustomCounter.class, "i");

        private int i;

        protected int getAndIncrement() {
            int old;
            do {
                old = i;
            } while (!UPDATER.compareAndSet(this, old, old + 1));
            return old;
        }
    }

    private static class CasWithAtomicUpdaterWithVolatileCustomCounter {

        private static final AtomicIntegerFieldUpdater<CasWithAtomicUpdaterWithVolatileCustomCounter> UPDATER =
                AtomicIntegerFieldUpdater.newUpdater(CasWithAtomicUpdaterWithVolatileCustomCounter.class, "i");

        private volatile int i;

        protected int getAndIncrement() {
            int old;
            do {
                old = i;
            } while (!UPDATER.compareAndSet(this, old, old + 1));
            return old;
        }
    }
}
