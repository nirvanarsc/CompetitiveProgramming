package leetcode.weekly_contests.weekly_300_399.weekly_324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_2 {

    public int smallestValue(int n) {
        final boolean[] sieve = sieveOfEratosthenes();
        final List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        while (!sieve[n]) {
            int next = 0;
            int curr = n;
            for (int p : primes) {
                if (p > n) {
                    break;
                }
                while (curr % p == 0) {
                    next += p;
                    curr /= p;
                }
            }
            if (n == next) {
                break;
            }
            n = next;
        }
        return n;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e5;
        final boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
