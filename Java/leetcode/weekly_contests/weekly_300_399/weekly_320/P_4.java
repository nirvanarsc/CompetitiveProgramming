package leetcode.weekly_contests.weekly_300_399.weekly_320;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][] seen;
    static int[][] dp;

    public int beautifulPartitions(String s, int k, int minLength) {
        if (!isPrime(s.charAt(0))) {
            return 0;
        }
        final int n = s.length();
        seen = new boolean[n][k + 1];
        dp = new int[n][k + 1];
        return dfs(s.toCharArray(), 0, k, minLength);
    }

    private static boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    private static int dfs(char[] w, int idx, int k, int minL) {
        if (k < 0) {
            return 0;
        }
        if (idx == w.length) {
            return k == 0 ? 1 : 0;
        }
        if (seen[idx][k]) {
            return dp[idx][k];
        }
        int res = 0;
        for (int i = idx + minL - 1; i < w.length; i++) {
            if (!isPrime(w[i]) && (i == w.length - 1 || isPrime(w[i + 1]))) {
                res = (res + dfs(w, i + 1, k - 1, minL)) % MOD;
            }
        }
        seen[idx][k] = true;
        return dp[idx][k] = res;
    }
}
