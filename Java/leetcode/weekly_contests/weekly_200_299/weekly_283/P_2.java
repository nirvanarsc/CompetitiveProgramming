package leetcode.weekly_contests.weekly_200_299.weekly_283;

import java.util.Arrays;

public class P_2 {

    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        Arrays.sort(nums);
        final int n = nums.length;
        final int[] copy = new int[n + 2];
        copy[n + 1] = (int) 2e9;
        System.arraycopy(nums, 0, copy, 1, n);
        for (int i = 0; i < n + 1 && k > 0; i++) {
            final int diff = copy[i + 1] - copy[i];
            if (diff > 1) {
                final int take = Math.min(k, diff - 1);
                res += f(copy[i] + take) - f(copy[i]);
                k -= take;
            }
        }
        return res;
    }

    private static long f(long n) {
        return (n * (n + 1)) / 2;
    }
}
