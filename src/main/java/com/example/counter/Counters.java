package com.example.counter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/** Counter implementations used by the tests in this package. */
public final class Counters {
    private Counters() {}

    public interface Counter {
        int getAndIncrement();
    }

    public static final class Plain implements Counter {
        private int i;
        public int getAndIncrement() { return i++; }
    }

    public static final class Synchronized implements Counter {
        private int i;
        public synchronized int getAndIncrement() { return i++; }
    }

    public static final class Volatile implements Counter {
        private volatile int i;
        public int getAndIncrement() { return i++; }
    }

    public static final class CasWithoutVolatile implements Counter {
        private int i;
        public int getAndIncrement() {
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

    public static final class CasWithVolatile implements Counter {
        private volatile int i;
        public int getAndIncrement() {
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

    public static final class CasWithAtomicUpdaterWithoutVolatile implements Counter {
        private static final AtomicIntegerFieldUpdater<CasWithAtomicUpdaterWithoutVolatile> UPDATER =
                AtomicIntegerFieldUpdater.newUpdater(CasWithAtomicUpdaterWithoutVolatile.class, "i");
        private int i;
        public int getAndIncrement() {
            int old;
            do {
                old = i;
            } while (!UPDATER.compareAndSet(this, old, old + 1));
            return old;
        }
    }

    public static final class CasWithAtomicUpdaterWithVolatile implements Counter {
        private static final AtomicIntegerFieldUpdater<CasWithAtomicUpdaterWithVolatile> UPDATER =
                AtomicIntegerFieldUpdater.newUpdater(CasWithAtomicUpdaterWithVolatile.class, "i");
        private volatile int i;
        public int getAndIncrement() {
            int old;
            do {
                old = i;
            } while (!UPDATER.compareAndSet(this, old, old + 1));
            return old;
        }
    }
}
