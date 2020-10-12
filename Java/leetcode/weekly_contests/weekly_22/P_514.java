package leetcode.weekly_contests.weekly_22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_514 {

    public int findRotateStepsBottomUp(String ring, String key) {
        final int n = ring.length();
        final int m = key.length();
        final int[][] dp = new int[m][n];
        final int inf = (int) 1e9;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = inf;
                for (int k = 0; k < n; ++k) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        final int diff = Math.abs(j - k);
                        final int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + m;
    }

    public int findRotateSteps(String ring, String key) {
        final Map<Character, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            indices.computeIfAbsent(ring.charAt(i), v -> new ArrayList<>()).add(i);
        }
        return helper(ring, key, 0, 0, indices, new Integer[ring.length()][key.length()]);
    }

    public int helper(String ring, String key, int r, int k, Map<Character, List<Integer>> indices,
                      Integer[][] dp) {
        if (k == key.length()) {
            return 0;
        }
        if (dp[r][k] != null) {
            return dp[r][k];
        }
        int res = Integer.MAX_VALUE;
        for (int next : indices.get(key.charAt(k))) {
            final int diff = Math.abs(r - next);
            final int curr = 1 + Math.min(diff, ring.length() - diff) +
                             helper(ring, key, next, k + 1, indices, dp);
            res = Math.min(res, curr);
        }
        return dp[r][k] = res;
    }
}
