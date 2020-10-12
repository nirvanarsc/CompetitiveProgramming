package leetcode.weekly_contests.weekly_5;

public class P_403 {

    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 0, new Boolean[stones.length][stones.length]);
    }

    private static boolean dfs(int[] stones, int curr, int prev, Boolean[][] dp) {
        if (curr == stones.length - 1) {
            return true;
        }
        if (dp[curr][prev] != null) {
            return dp[curr][prev];
        }
        boolean res = false;
        final int jump = stones[curr] - stones[prev];
        for (int j = curr + 1; j < stones.length; j++) {
            if (jump - 1 <= stones[j] - stones[curr] && stones[j] - stones[curr] <= jump + 1) {
                if (dfs(stones, j, curr, dp)) {
                    res = true;
                    break;
                }
            }
        }
        return dp[curr][prev] = res;
    }
}
