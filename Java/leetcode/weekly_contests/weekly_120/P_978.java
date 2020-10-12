package leetcode.weekly_contests.weekly_120;

public class P_978 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int maxTurbulenceSize(int[] A) {
        final int[][] dp = new int[A.length][2];
        int maxLen = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (A[i - 1] > A[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            maxLen = Math.max(maxLen, Math.max(dp[i][0], dp[i][1]));
        }
        return maxLen + 1;
    }
}
