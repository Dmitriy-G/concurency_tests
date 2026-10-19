package com.example.locks;

import org.openjdk.jmh.infra.Blackhole;

public final class BlackHole5KWorkload {

    private int test = 0;

    public int sum() {
        Blackhole.consumeCPU(5_000);
        return test;
    }

    public void incrementOne() {
        test++;
    }
}
