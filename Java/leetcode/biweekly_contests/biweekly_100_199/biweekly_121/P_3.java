package leetcode.biweekly_contests.biweekly_100_199.biweekly_121;

public class P_3 {

    static boolean[] seen;
    static int[] dp;

    public int minimumOperationsToMakeEqual(int x, int y) {
        seen = new boolean[x + 1];
        dp = new int[x + 1];
        return dfs(x, y);
    }

    private static int dfs(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        if (seen[x]) {
            return dp[x];
        }
        int res = x - y;
        res = Math.min(res, 1 + x % 11 + dfs(x / 11, y));
        if (x % 11 != 0) {
            res = Math.min(res, 1 + 11 - (x % 11) + dfs(1 + (x / 11), y));
        }
        res = Math.min(res, 1 + x % 5 + dfs(x / 5, y));
        if (x % 5 != 0) {
            res = Math.min(res, 1 + 5 - (x % 5) + dfs(1 + (x / 5), y));
        }
        seen[x] = true;
        return dp[x] = res;
    }
}
