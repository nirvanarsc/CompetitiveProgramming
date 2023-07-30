package leetcode.weekly_contests.weekly_300_399.weekly_356;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static int[][][] dp;
    static boolean[][][] seen;

    public int countSteppingNumbers(String low, String high) {
        return (f1(high) - f1(low) + isStepping(low) + MOD) % MOD;
    }

    private static int f1(String w) {
        final int n = w.length();
        dp = new int[n][11][2];
        seen = new boolean[n][11][2];
        final int[] remap = new int[n];
        for (int i = 0; i < n; i++) {
            remap[i] = w.charAt(i) - '0';
        }
        int res = dfs(remap, 0, -1, 0);
        for (int i = 1; i < n; i++) {
            res = (res + f2(i - 1)) % MOD;
        }
        return res;
    }

    private static int f2(int len) {
        final int[][] dp = new int[len + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) {
                    dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                }
                if (j < 9) {
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[len][i]) % MOD;
        }
        return res;
    }

    private static int dfs(int[] w, int idx, int digit, int smaller) {
        if (idx == w.length) {
            return 1;
        }
        if (seen[idx][digit + 1][smaller]) {
            return dp[idx][digit + 1][smaller];
        }
        int res = 0;
        if (digit == -1) {
            for (int i = 1; i <= w[idx]; i++) {
                res = (res + dfs(w, idx + 1, i, w[idx] == i ? 0 : 1)) % MOD;
            }
        } else if (smaller == 0) {
            if (digit != 0 && w[idx] >= digit - 1) {
                res = (res + dfs(w, idx + 1, digit - 1, w[idx] == (digit - 1) ? 0 : 1)) % MOD;
            }
            if (digit != 9 && w[idx] >= digit + 1) {
                res = (res + dfs(w, idx + 1, digit + 1, w[idx] == (digit + 1) ? 0 : 1)) % MOD;
            }
        } else {
            if (digit != 0) {
                res = (res + dfs(w, idx + 1, digit - 1, 1)) % MOD;
            }
            if (digit != 9) {
                res = (res + dfs(w, idx + 1, digit + 1, 1)) % MOD;
            }
        }
        seen[idx][digit + 1][smaller] = true;
        return dp[idx][digit + 1][smaller] = res;
    }

    private static int isStepping(String w) {
        for (int i = 1; i < w.length(); i++) {
            if (Math.abs(w.charAt(i) - w.charAt(i - 1)) != 1) {
                return 0;
            }
        }
        return 1;
    }
}
