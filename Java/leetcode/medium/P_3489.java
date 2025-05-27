package leetcode.medium;

import java.util.Arrays;

public class P_3489 {

    public int minZeroArray(int[] nums, int[][] queries) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, f(nums[i], i, queries));
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static int f(int num, int idx, int[][] queries) {
        final int q = queries.length;
        final int[][] dp = new int[q + 1][num + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < q; i++) {
            for (int j = 0; j <= num; j++) {
                if (queries[i][0] <= idx &&
                    idx <= queries[i][1] && j + queries[i][2] <= num &&
                    dp[i][j] != (int) 1e9) {
                    dp[i + 1][j + queries[i][2]] = Math.min(dp[i + 1][j + queries[i][2]], i + 1);
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i <= q; i++) {
            res = Math.min(res, dp[i][num]);
        }
        return res;
    }
}
