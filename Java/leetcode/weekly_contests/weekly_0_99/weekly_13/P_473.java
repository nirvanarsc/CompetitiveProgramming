package leetcode.weekly_contests.weekly_0_99.weekly_13;

import java.util.ArrayList;
import java.util.List;

public class P_473 {

    static int n;
    static int[] dp;
    static boolean[] seen;

    public boolean makesquare(int[] nums) {
        n = nums.length;
        dp = new int[1 << n];
        seen = new boolean[1 << n];
        final int all = (1 << n) - 1;
        long sum = 0;
        for (int matchstick : nums) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, all, sum / 4, 0) == 1;
    }

    private static int dfs(int[] nums, int mask, long target, long curr) {
        if (mask == 0) {
            return curr == 0 ? 1 : 0;
        }
        if (seen[mask]) {
            return dp[mask];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                if (nums[i] + curr <= target) {
                    res = Math.max(res, dfs(nums, mask ^ (1 << i), target, (curr + nums[i]) % target));
                }
            }
        }
        seen[mask] = true;
        return dp[mask] = res;
    }

    public boolean makesquareMasks(int[] matchsticks) {
        final int n = matchsticks.length;
        final int all = (1 << n) - 1;
        final long[] sums = new long[1 << n];
        long sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final List<Integer> good = new ArrayList<>();
        for (int mask = 0; mask < 1 << n; mask++) {
            long curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += matchsticks[i];
                }
            }
            sums[mask] = curr;
            if (curr == sum / 2) {
                good.add(mask);
            }
        }
        for (int mask : good) {
            if (f(mask, sums) && f(all ^ mask, sums)) {
                return true;
            }
        }
        return false;
    }

    private static boolean f(int mask, long[] sums) {
        for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
            if (sums[subMask] == sums[mask ^ subMask]) {
                return true;
            }
        }
        return false;
    }
}
