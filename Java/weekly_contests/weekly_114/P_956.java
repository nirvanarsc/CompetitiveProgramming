package weekly_contests.weekly_114;

public class P_956 {

    public int tallestBillboard(int[] rods) {
        return help(rods, 0, 0, 0, new Integer[rods.length][5001]);
    }

    private static int help(int[] rods, int i, int left, int right, Integer[][] dp) {
        if (i == rods.length) {
            return left == right ? left : -1;
        }
        if (dp[i][Math.abs(left - right)] != null) {
            return dp[i][Math.abs(left - right)] == -1 ? -1
                                                       : Math.max(left, right) + dp[i][Math.abs(left - right)];
        }
        final int addL = help(rods, i + 1, left + rods[i], right, dp);
        final int addR = help(rods, i + 1, left, right + rods[i], dp);
        final int skip = help(rods, i + 1, left, right, dp);
        final int ans = Math.max(skip, Math.max(addL, addR));
        dp[i][Math.abs(left - right)] = ans == -1 ? -1 : ans - Math.max(left, right);
        return ans;
    }
}
