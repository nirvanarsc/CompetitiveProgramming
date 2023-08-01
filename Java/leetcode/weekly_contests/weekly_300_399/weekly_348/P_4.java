package leetcode.weekly_contests.weekly_300_399.weekly_348;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int count(String num1, String num2, int min_sum, int max_sum) {
        int res = (f2(num2, min_sum, max_sum) - f2(num1, min_sum, max_sum) + MOD) % MOD;
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (min_sum <= sum && sum <= max_sum) {
            res = (res + 1) % MOD;
        }
        return res;
    }

    private static int f1(int len, int min, int max) {
        final int[][] dp = new int[len + 1][max + 1];
        for (int i = 1; i < Math.min(max + 1, 10); i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= max; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j + k <= max) {
                        dp[i + 1][j + k] = (dp[i + 1][j + k] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = min; j <= max; j++) {
                res = (res + dp[i][j]) % MOD;
            }
        }
        return res;
    }

    private static int f2(String s, int min, int max) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[][][] dp = new int[n][max + 1][2];
        for (int i = 1; i < Math.min(max + 1, 10); i++) {
            if (w[0] - '0' < i) {
                break;
            }
            final int smaller = (w[0] - '0') == i ? 0 : 1;
            dp[0][i][smaller] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= max; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j + k <= max) {
                        dp[i][j + k][1] = (dp[i][j + k][1] + dp[i - 1][j][1]) % MOD;
                        if (k < w[i] - '0') {
                            dp[i][j + k][1] = (dp[i][j + k][1] + dp[i - 1][j][0]) % MOD;
                        } else if (k == w[i] - '0') {
                            dp[i][j + k][0] = (dp[i][j + k][0] + dp[i - 1][j][0]) % MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < 2; j++) {
                res = (res + dp[n - 1][i][j]) % MOD;
            }
        }
        return (res + f1(n - 1, min, max)) % MOD;
    }
}
