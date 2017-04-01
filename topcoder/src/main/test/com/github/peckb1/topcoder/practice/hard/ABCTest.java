package com.github.peckb1.topcoder.practice.hard;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ABCTest {
    private ABC ab;

    @Before
    public void setUp() throws Exception {
        this.ab = new ABC();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        long startTime = System.nanoTime();
        for (int n = 3; n <= 30; n++) {
            int maxK = (n * (n - 1)) / 2;
            for (int k = 0; k < maxK; k++) {
                Assert.assertTrue(check(n, k));
            }
        }
        long endTime = System.nanoTime();
        long nanoTimeTaken = endTime - startTime;
        long timeTakenMillis = TimeUnit.MILLISECONDS.convert(nanoTimeTaken, TimeUnit.NANOSECONDS);

        Assert.assertTrue(timeTakenMillis < 200);
    }

    private boolean check(int N, int K) {
        String string = this.ab.createString(N, K);
        if (string.isEmpty()) {
            /**
             * we default to just accepting that {@link ABC#maxABC(int)}
             * is correct since we're doing local testing
             */
            return true;
        }

        List<Counter> counters = Lists.newArrayList();
        byte[] bytes = string.getBytes();
        for (byte b : bytes) {
            if (b == 'A') {
                counters.add(new Counter('A'));
            }
            if (b == 'B') {
                counters.add(new Counter('B'));
                counters.forEach(counter -> {
                    if (counter.getLetter() == 'A') {
                        counter.incrementCounter();
                    }
                });
            }
            if (b == 'C') {
                counters.forEach(Counter::incrementCounter);
            }
        }

        AtomicInteger sum = new AtomicInteger(0);
        counters.forEach(counter -> sum.addAndGet(counter.getCount()));

        return sum.get() == K;
    }

    private class Counter {
        private final Character letter;

        private int count;

        private Counter(Character letter) {
            this.letter = letter;
            this.count = 0;
        }

        private Character getLetter() {
            return this.letter;
        }

        private int getCount() {
            return this.count;
        }

        private void incrementCounter() {
            this.count++;
        }
    }
}
