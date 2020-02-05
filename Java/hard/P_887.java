package hard;

public class P_887 {

    public int superEggDrop(int k, int n) {
        final int[][] dp = new int[n + 1][k + 1];
        int i = 0;
        while (dp[i][k] < n) {
            i++;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
        }
        return i;
    }

    public int superEggDropSpace(int k, int n) {
        final int[] dp = new int[k + 1];
        int i;
        for (i = 0; dp[k] < n; ++i) {
            for (int j = k; j > 0; --j) {
                dp[j] += dp[j - 1] + 1;
            }
        }
        return i;
    }
}
