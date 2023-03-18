package leetcode.biweekly_contests.biweekly_0_99.biweekly_48;

import java.util.Arrays;

public class P_1799 {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int maxScore(int[] nums) {
        final int n = nums.length;
        final int[][] gcd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }
        final int[][] dp = new int[1 << n][n / 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, nums, (1 << n) - 1, gcd, dp);
    }

    private static int dfs(int mask, int turn, int[] arr, int end, int[][] gcd, int[][] dp) {
        if (mask == end) {
            return 0;
        }
        if (dp[mask][turn] != -1) {
            return dp[mask][turn];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((mask & (1 << i)) == 0) {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j && (mask & (1 << j)) == 0) {
                        mask ^= 1 << i;
                        mask ^= 1 << j;
                        res = Math.max(res, (turn + 1) * gcd[i][j] + dfs(mask, turn + 1, arr, end, gcd, dp));
                        mask ^= 1 << i;
                        mask ^= 1 << j;
                    }
                }
            }
        }
        return dp[mask][turn] = res;
    }
}
