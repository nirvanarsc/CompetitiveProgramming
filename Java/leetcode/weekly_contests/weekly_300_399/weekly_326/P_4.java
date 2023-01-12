package leetcode.weekly_contests.weekly_300_399.weekly_326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    public int[] closestPrimes(int left, int right) {
        final boolean[] sieve = sieveOfEratosthenes(right);
        final List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        final int n = primes.size();
        int best = (int) 1e9;
        final int[] res = { -1, -1 };
        for (int i = 0; i < n - 1; i++) {
            final int u = primes.get(i);
            final int v = primes.get(i + 1);
            if (v - u < best) {
                best = v - u;
                res[0] = u;
                res[1] = v;
            }
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes(int n) {
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
