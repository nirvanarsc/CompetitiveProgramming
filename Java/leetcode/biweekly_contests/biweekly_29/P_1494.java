package leetcode.biweekly_contests.biweekly_29;

public class P_1494 {

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        return dfs(n, k, dependencies, 0, (1 << n) - 1, new Integer[1 << n]);
    }

    private static int dfs(int n, int k, int[][] dependencies, int mask, int target, Integer[] dp) {
        if (mask == target) {
            return 0;
        }
        if (dp[mask] != null) {
            return dp[mask];
        }
        int res = (int) 1e9;
        final int[] inDegree = new int[n];
        for (int[] dep : dependencies) {
            final int u = dep[0] - 1;
            final int v = dep[1] - 1;
            if ((mask & (1 << u)) == 0) {
                inDegree[v]++;
            }
        }
        int currMask = 0;
        for (int take = 0; take < n; take++) {
            if ((mask & (1 << take)) == 0 && inDegree[take] == 0) {
                currMask |= 1 << take;
            }
        }
        if (Integer.bitCount(currMask) <= k) {
            res = Math.min(res, 1 + dfs(n, k, dependencies, mask | currMask, target, dp));
        } else {
            for (int subMask = 0; subMask <= currMask; subMask++) {
                if (Integer.bitCount(subMask) == k && (currMask | subMask) == currMask) {
                    res = Math.min(res, 1 + dfs(n, k, dependencies, mask | subMask, target, dp));
                }
            }
        }
        return dp[mask] = res;
    }
}
