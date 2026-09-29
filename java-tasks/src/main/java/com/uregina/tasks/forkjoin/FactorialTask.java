package com.uregina.tasks.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 4;

    private final int from;
    private final int to;

    public FactorialTask(int n) {
        this(1, n);
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
    }

    private FactorialTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if (to - from + 1 <= THRESHOLD) {
            long result = 1;
            for (int i = from; i <= to; i++) {
                result = Math.multiplyExact(result, i);
            }
            return result;
        }

        int middle = (from + to) >>> 1;
        FactorialTask left = new FactorialTask(from, middle);
        FactorialTask right = new FactorialTask(middle + 1, to);

        left.fork();
        long rightResult = right.compute();
        long leftResult = left.join();

        return Math.multiplyExact(leftResult, rightResult);
    }
}
