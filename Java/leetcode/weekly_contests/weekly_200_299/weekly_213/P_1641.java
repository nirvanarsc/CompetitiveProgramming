package leetcode.weekly_contests.weekly_200_299.weekly_213;

public class P_1641 {

    public int countVowelStrings(int n) {
        final int[][] dp = new int[n][5];
        dp[0] = new int[] { 1, 1, 1, 1, 1 };
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++) {
                    dp[i + 1][j] += dp[i][k];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[n - 1][i];
        }
        return res;
    }
}
