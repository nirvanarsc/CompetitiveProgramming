package leetcode.weekly_contests.weekly_56;

public class P_718 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int findLength(int[] A, int[] B) {
        final int n = A.length;
        final int m = B.length;
        final int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res;
    }
}
