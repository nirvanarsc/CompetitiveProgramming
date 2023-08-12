package leetcode.weekly_contests.weekly_300_399.weekly_352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_2 {

    static boolean[] sieve;

    public List<List<Integer>> findPrimePairs(int n) {
        if (sieve == null) {
            //noinspection NonThreadSafeLazyInitialization
            sieve = sieveOfEratosthenes();
        }
        final List<List<Integer>> res = new ArrayList<>();
        for (int x = 2; x <= n / 2; x++) {
            if (sieve[x] && sieve[n - x]) {
                res.add(Arrays.asList(x, n - x));
            }
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e6;
        final boolean[] prime = new boolean[n + 5];
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
