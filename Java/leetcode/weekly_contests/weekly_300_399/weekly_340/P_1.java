package leetcode.weekly_contests.weekly_300_399.weekly_340;

import java.util.Arrays;

public class P_1 {

    public int diagonalPrime(int[][] nums) {
        final int n = nums.length;
        final boolean[] sieve = sieveOfEratosthenes();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sieve[nums[i][i]]) {
                res = Math.max(res, nums[i][i]);
            }
            if (sieve[nums[i][n - 1 - i]]) {
                res = Math.max(res, nums[i][n - 1 - i]);
            }
        }
        return res;
    }

    private static boolean[] sieveOfEratosthenes() {
        final int n = (int) 4e6;
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
