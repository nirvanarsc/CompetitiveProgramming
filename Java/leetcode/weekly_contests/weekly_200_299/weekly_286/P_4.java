package leetcode.weekly_contests.weekly_200_299.weekly_286;

import java.util.List;

public class P_4 {

    static boolean[][] seen;
    static int[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        final int n = piles.size();
        seen = new boolean[n][k + 1];
        dp = new int[n][k + 1];
        return dfs(piles, 0, k);
    }

    private static int dfs(List<List<Integer>> piles, int idx, int k) {
        if (idx == piles.size()) {
            return 0;
        }
        if (seen[idx][k]) {
            return dp[idx][k];
        }
        int res = 0;
        int add = 0;
        res = Math.max(res, dfs(piles, idx + 1, k));
        for (int i = 0; i < Math.min(piles.get(idx).size(), k); i++) {
            add += piles.get(idx).get(i);
            res = Math.max(res, add + dfs(piles, idx + 1, k - i - 1));
        }
        seen[idx][k] = true;
        return dp[idx][k] = res;
    }
}
