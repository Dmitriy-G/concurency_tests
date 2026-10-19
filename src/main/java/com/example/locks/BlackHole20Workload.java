package com.example.locks;

import org.openjdk.jmh.infra.Blackhole;

public final class BlackHole20Workload {

    private int test = 0;

    public int sum() {
        Blackhole.consumeCPU(20);
        return test;
    }

    public void incrementOne() {
        test++;
    }
}
