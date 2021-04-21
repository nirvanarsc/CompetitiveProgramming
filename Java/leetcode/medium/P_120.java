package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class P_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size();
        final int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                final int ll = j == 0 ? (int) 1e9 : dp[i - 1][j - 1];
                final int rr = dp[i - 1][j];
                dp[i][j] = triangle.get(i).get(j) + Math.min(ll, rr);
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
