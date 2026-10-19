package com.example.locks;

public final class LongArrayWorkload {
    private final long[] values = new long[1024];
    private int nextWriteIndex;

    public int sum() {
        long result = 0;
        for (long value : values) {
            result += value;
        }
        return (int) result;
    }

    public void incrementOne() {
        values[nextWriteIndex]++;
        nextWriteIndex = (nextWriteIndex + 1) % values.length;
    }
}
