package leetcode.biweekly_contests.biweekly_100_199.biweekly_111;

public class P_4 {

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return f(high, k) - f(low - 1, k);
    }

    private static int f(int high, int k) {
        final char[] w = String.valueOf(high).toCharArray();
        final int n = w.length;
        int res = 0;
        if (n % 2 == 0) {
            final int[][][][] dp = new int[n + 1][n + 1][k][2];
            dp[0][0][0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < k; l++) {
                        for (int m = 0; m < 2; m++) {
                            final int start = i == 0 ? 1 : 0;
                            if (m == 1) {
                                for (int p = start; p < 10; p++) {
                                    dp[i + 1][j + (p % 2 == 0 ? 1 : 0)][(l * 10 + p) % k][1] += dp[i][j][l][1];
                                }
                            } else {
                                for (int p = start; p <= w[i] - '0'; p++) {
                                    final int nc = p == w[i] - '0' ? 0 : 1;
                                    dp[i + 1][j + (p % 2 == 0 ? 1 : 0)][(l * 10 + p) % k][nc] += dp[i][j][l][0];
                                }
                            }
                        }
                    }
                }
            }
            res += dp[n][n / 2][0][0] + dp[n][n / 2][0][1];
        }
        final int[][][] dp2 = new int[n][n][k];
        dp2[0][0][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int l = 0; l < k; l++) {
                    final int start = i == 0 ? 1 : 0;
                    for (int p = start; p < 10; p++) {
                        dp2[i + 1][j + (p % 2 == 0 ? 1 : 0)][(l * 10 + p) % k] += dp2[i][j][l];
                    }
                }
            }
        }
        for (int i = 2; i < n; i += 2) {
            res += dp2[i][i / 2][0];

        }
        return res;
    }
}
