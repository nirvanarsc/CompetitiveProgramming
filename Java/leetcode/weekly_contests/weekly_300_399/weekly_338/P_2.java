package leetcode.weekly_contests.weekly_300_399.weekly_338;

import java.util.Arrays;
import java.util.TreeSet;

public class P_2 {

    public boolean primeSubOperation(int[] nums) {
        final boolean[] sieve = sieveOfEratosthenes();
        final TreeSet<Integer> primes = new TreeSet<>();
        for (int i = 0; i < (int) 1e3; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            final int u = i == 0 ? 0 : nums[i - 1];
            final int diff = nums[i] - u;
            final Integer v = primes.lower(diff);
            if (v != null) {
                nums[i] -= v;
            }
        }
        for (int i = 1; i < n; i++) {
            if (!(nums[i - 1] < nums[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 1e3;
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
