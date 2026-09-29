package com.uregina.tasks.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTaskTest {

    private final ForkJoinPool pool = new ForkJoinPool();

    @Test
    void smallValues() {
        assertEquals(1L, pool.invoke(new FactorialTask(0)));
        assertEquals(1L, pool.invoke(new FactorialTask(1)));
        assertEquals(120L, pool.invoke(new FactorialTask(5)));
        assertEquals(3_628_800L, pool.invoke(new FactorialTask(10)));
    }

    @Test
    void largestValueThatFitsInLong() {
        assertEquals(2_432_902_008_176_640_000L, pool.invoke(new FactorialTask(20)));
    }

    @Test
    void overflowAndNegative() {
        assertThrows(ArithmeticException.class, () -> pool.invoke(new FactorialTask(21)));
        assertThrows(IllegalArgumentException.class, () -> new FactorialTask(-1));
    }
}
