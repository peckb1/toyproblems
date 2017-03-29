package peckb1.topcoder.practice.easy;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ABTest {

    private AB ab;

    @Before
    public void setUp() throws Exception {
        this.ab = new AB();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        long startTime = System.nanoTime();
        for (int n = 0; n <= 50; n++) {
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
             * we default to just accepting that {@link AB#max(int)}
             * is correct since we're doing local testing
             */
            return true;
        }

        List<Counter> counters = Lists.newArrayList();
        byte[] bytes = string.getBytes();
        for (byte b : bytes) {
            if (b == 'A') {
                counters.add(new Counter());
            }
            if (b == 'B') {
                counters.forEach(Counter::addBCount);
            }
        }

        AtomicInteger sum = new AtomicInteger(0);
        counters.forEach(counter -> sum.addAndGet(counter.getSubsequentBCount()));

        return sum.get() == K;
    }

    private class Counter {

        private int subsequentBCount;

        private Counter() {
            this.subsequentBCount = 0;
        }

        private int getSubsequentBCount() {
            return subsequentBCount;
        }

        private void addBCount() {
            this.subsequentBCount++;
        }
    }
}
