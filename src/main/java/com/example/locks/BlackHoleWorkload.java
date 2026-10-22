package com.example.locks;

import org.openjdk.jmh.infra.Blackhole;

public final class BlackHoleWorkload {

    private int test = 0;

    public int sum() {
       // Blackhole.consumeCPU(100);
//        Blackhole.consumeCPU(2_000);
//        Blackhole.consumeCPU(5_000);
//        Blackhole.consumeCPU(10_000);
        // Blackhole.consumeCPU(15_000);
        // Blackhole.consumeCPU(20_000);
//        Blackhole.consumeCPU(25_000);
         Blackhole.consumeCPU(30_000);
        //Blackhole.consumeCPU(40_000);
//        Blackhole.consumeCPU(50_000);
        return test;
    }

    public void incrementOne() {
        test++;
    }
}
