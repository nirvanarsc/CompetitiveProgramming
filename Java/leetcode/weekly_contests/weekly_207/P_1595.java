package leetcode.weekly_contests.weekly_207;

import java.util.Arrays;
import java.util.List;

public class P_1595 {

    public int connectTwoGroups(List<List<Integer>> cost) {
        final int n = cost.size();
        final int m = cost.get(0).size();
        final int[] minSize = new int[m];
        Arrays.fill(minSize, (int) 1e9);
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                minSize[j] = Math.min(minSize[j], cost.get(i).get(j));
            }
        }
        return dfs(cost, minSize, 0, 0, new Integer[n][1 << m]);
    }

    private static int dfs(List<List<Integer>> cost, int[] minSize, int i, int mask, Integer[][] dp) {
        if (i == cost.size()) {
            int res = 0;
            for (int j = 0; j < cost.get(0).size(); ++j) {
                if ((mask & (1 << j)) == 0) {
                    res += minSize[j];
                }
            }
            return res;
        }
        if (dp[i][mask] != null) {
            return dp[i][mask];
        }
        int res = (int) 1e9;
        for (int j = 0; j < cost.get(0).size(); ++j) {
            res = Math.min(res, cost.get(i).get(j) + dfs(cost, minSize, i + 1, mask | (1 << j), dp));
        }
        return dp[i][mask] = res;
    }
}
