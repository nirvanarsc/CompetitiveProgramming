package leetcode.weekly_contests.weekly_200_299.weekly_292;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    static int n;
    static boolean[] seen;
    static int[] dp;

    public int countTexts(String pressedKeys) {
        n = pressedKeys.length();
        seen = new boolean[n];
        dp = new int[n];
        return dfs(pressedKeys.toCharArray(), 0);
    }

    private static int dfs(char[] w, int idx) {
        if (idx == n) {
            return 1;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 0;
        res = (res + dfs(w, idx + 1)) % MOD;
        if (idx < (n - 1) && w[idx] == w[idx + 1]) {
            res = (res + dfs(w, idx + 2)) % MOD;
        }
        if (idx < (n - 2) && w[idx] == w[idx + 1] && w[idx + 1] == w[idx + 2]) {
            res = (res + dfs(w, idx + 3)) % MOD;
        }
        if (w[idx] == '7' || w[idx] == '9') {
            if (idx < (n - 3) && w[idx] == w[idx + 1] && w[idx + 1] == w[idx + 2] && w[idx + 2] == w[idx + 3]) {
                res = (res + dfs(w, idx + 4)) % MOD;
            }
        }
        seen[idx] = true;
        return dp[idx] = res;
    }
}
