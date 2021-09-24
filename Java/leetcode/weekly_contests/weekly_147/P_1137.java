package leetcode.weekly_contests.weekly_147;

public class P_1137 {

    public int tribonacci(int n) {
        final int[] dp = new int[100];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
