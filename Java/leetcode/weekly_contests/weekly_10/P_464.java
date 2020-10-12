package leetcode.weekly_contests.weekly_10;

public class P_464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        return dfs((1 << maxChoosableInteger) - 1, maxChoosableInteger, desiredTotal,
                   new Boolean[1 << maxChoosableInteger]);
    }

    private static boolean dfs(int choices, int n, int t, Boolean[] dp) {
        if (dp[choices] != null) {
            return dp[choices];
        }
        boolean res = false;
        for (int i = 0; i < n; i++) {
            if ((choices & (1 << i)) != 0) {
                if (t <= i + 1 || !dfs(choices ^ (1 << i), n, t - (i + 1), dp)) {
                    res = true;
                    break;
                }
            }
        }
        return dp[choices] = res;
    }
}
