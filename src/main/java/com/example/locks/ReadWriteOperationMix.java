package com.example.locks;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class ReadWriteOperationMix {
    @Param({"50"})
    public int writePercent;

    private int schedule;

    @Setup(Level.Iteration)
    public void reset() {
        schedule = 0;
    }

    public boolean nextIsWrite() {
        schedule += writePercent;
        if (schedule >= 100) {
            schedule -= 100;
            return true;
        }
        return false;
    }
}
