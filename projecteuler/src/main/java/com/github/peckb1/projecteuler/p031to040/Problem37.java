package com.github.peckb1.projecteuler.p031to040;

import com.github.peckb1.projecteuler.util.PrimeUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits
 * from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem37 {

    private final Set<Integer> primes = new HashSet<>();
    private final Set<Integer> truncatablePrimes = new HashSet<>();

    public int sumTruncatablePrimes() {
        int n = 10;
        while (truncatablePrimes.size() != 11) {
            if (PrimeUtils.isPrimePE(n)) {
                primes.add(n);
                if (isTruncatablePrime(n)) {
                    truncatablePrimes.add(n);
                }
            }
            n++;
        }
        return sum(truncatablePrimes);
    }

    private int sum(Collection<Integer> truncatablePrimes) {
        return truncatablePrimes.stream().reduce(0, (x, y) -> x + y);
    }

    private boolean isTruncatablePrime(int n) {
        boolean isTruncatablePrime = primes.contains(n) || PrimeUtils.isPrimePE(n);

        int x = n / 10;
        while (isTruncatablePrime & x > 0) {
            isTruncatablePrime = primes.contains(x) || PrimeUtils.isPrimePE(x);
            x /= 10;
        }

        int digits = (int) (Math.log10(n) + 1);
        for(int d = digits - 1; isTruncatablePrime & d > 0; d--) {
            int y = (int) (n % Math.pow(10, d));
            isTruncatablePrime = primes.contains(x) || PrimeUtils.isPrimePE(y);
        }

        return isTruncatablePrime;
    }

    public static void main(String[] args) {
        Problem37 problem37 = new Problem37();
        System.out.println(problem37.sumTruncatablePrimes());
    }

}
