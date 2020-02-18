package weekly_149;

public class P_1155 {

    private static final int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int d, int f, int target) {
        if (d * f < target) {
            return 0;
        }
        return recurse(d, f, target, 0, new Integer[d + 1][target + 1]);
    }

    private static int recurse(int d, int f, int target, int curr, Integer[][] dp) {
        if (d == 0 && curr == target) {
            return 1;
        }
        if (d == 0 || curr > target) {
            return 0;
        }
        if (dp[d][curr] != null) {
            return dp[d][curr];
        }

        int res = 0;
        for (int i = 1; i <= f; i++) {
            res = (res + recurse(d - 1, f, target, curr + i, dp)) % MOD;
        }
        return dp[d][curr] = res;
    }
}
