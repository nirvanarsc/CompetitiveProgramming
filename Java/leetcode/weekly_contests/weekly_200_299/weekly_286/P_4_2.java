package leetcode.weekly_contests.weekly_200_299.weekly_286;

import java.util.List;

public class P_4_2 {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        final int n = piles.size();
        final int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int kk = 0; kk <= k; kk++) {
                dp[i + 1][kk] = Math.max(dp[i + 1][kk], dp[i][kk]);
                int add = 0;
                for (int j = 0; j < Math.min(piles.get(i).size(), kk); j++) {
                    add += piles.get(i).get(j);
                    dp[i + 1][kk - j - 1] = Math.max(dp[i + 1][kk - j - 1], dp[i][kk] + add);
                }
            }
        }
        return dp[n][0];
    }
}
