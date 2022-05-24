package leetcode.weekly_contests.weekly_100_199.weekly_185;

public class P_1420 {

    private static final int MOD = (int) (1e9 + 7);

    public int numOfArrays(int n, int m, int k) {
        return dfs(n, m, k, 0, 0, 0, new Integer[n + 1][m + 1][k + 1]);
    }

    private static int dfs(int n, int m, int k, int i, int currMax, int searchCost, Integer[][][] dp) {
        if (i == n) {
            return k == searchCost ? 1 : 0;
        }
        if (dp[i][currMax][searchCost] != null) {
            return dp[i][currMax][searchCost];
        }
        int ans = 0;
        for (int num = 1; num <= m; num++) {
            int newCost = searchCost;
            int newMax = currMax;
            if (num > currMax) {
                newCost++;
                newMax = num;
            }
            if (newCost > k) {
                break;
            }
            ans = (ans + dfs(n, m, k, i + 1, newMax, newCost, dp)) % MOD;
        }
        return dp[i][currMax][searchCost] = ans;
    }
}
