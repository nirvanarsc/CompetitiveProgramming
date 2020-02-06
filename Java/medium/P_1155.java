package medium;

public class P_1155 {

    private static final int MOD = (int) (1e9 + 7);

    public int numRollsToTarget(int d, int f, int target) {
        if (d * f < target) {
            return 0;
        }
        return recurse(d, f, 0, target, new Integer[d + 1][target + 1]);
    }

    private static int recurse(int d, int f, int curr, int target, Integer[][] dp) {
        if (curr == target && d == 0) {
            return 1;
        }
        if (curr > target || d < 0) {
            return 0;
        }
        if (dp[d][curr] != null) {
            return dp[d][curr];
        }

        int res = 0;
        for (int i = 1; i <= f; i++) {
            res += recurse(d - 1, f, curr + i, target, dp);
            res %= MOD;
        }

        return dp[d][curr] = res;
    }
}
