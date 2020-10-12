package leetcode.weekly_contests.weekly_43;

public class P_651 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int maxA(int N) {
        final int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}
