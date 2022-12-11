package leetcode.weekly_contests.weekly_300_399.weekly_320;

public class P_4_dp {

    private static final int MOD = (int) (1e9 + 7);

    public int beautifulPartitions(String s, int k, int minLength) {
        if (!isPrime(s.charAt(0))) {
            return 0;
        }
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int j = 0; j < k; j++) {
            int pre = 0;
            for (int i = 0; i < n; i++) {
                if (i >= minLength - 1) {
                    pre = (pre + dp[i - minLength + 1][j]) % MOD;
                }
                if (!isPrime(w[i]) && (i == n - 1 || isPrime(w[i + 1]))) {
                    dp[i + 1][j + 1] = pre;
                }
            }
        }
        return dp[n][k];
    }

    private static boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }
}
