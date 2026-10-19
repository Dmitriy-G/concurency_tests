package com.example.locks;

public final class HeavyWorkload {

    private int test = 0;

    public int sum() {
        boolean f = true;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            f = !f;
        }
        return test;
    }

    public void incrementOne() {
        test++;
    }
}
