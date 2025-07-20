package leetcode.biweekly_contests.biweekly_100_199.biweekly_161;

import java.util.Arrays;

public class P_1 {

    public long splitArray(int[] nums) {
        final int n = nums.length;
        final boolean[] sieve = sieveOfEratosthenes(n);
        long l = 0;
        long r = 0;
        for (int i = 0; i < n; i++) {
            l += sieve[i] ? nums[i] : 0;
            r += sieve[i] ? 0 : nums[i];
        }
        return Math.abs(l - r);
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
