package leetcode.biweekly_contests.biweekly_0_99.biweekly_92;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][][][] seen;
    static int[][][][] dp;

    public int countPalindromes(String s) {
        final int n = s.length();
        seen = new boolean[n][11][11][6];
        dp = new int[n][11][11][6];
        return dfs(s.toCharArray(), 0, 10, 10, 0);
    }

    private static int dfs(char[] w, int idx, int l, int r, int u) {
        if (idx == w.length) {
            return u == 5 ? 1 : 0;
        }
        if (seen[idx][l][r][u]) {
            return dp[idx][l][r][u];
        }
        int res = 0;
        switch (u) {
            case 0:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
                res = (res + dfs(w, idx + 1, w[idx] - '0', r, u + 1)) % MOD;
                break;
            case 1:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
                res = (res + dfs(w, idx + 1, l, w[idx] - '0', u + 1)) % MOD;
                break;
            case 2:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
                res = (res + dfs(w, idx + 1, l, r, u + 1)) % MOD;
                break;
            case 3:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
                if (r == (w[idx] - '0')) {
                    res = (res + dfs(w, idx + 1, l, r, u + 1)) % MOD;
                }
                break;
            case 4:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
                if (l == (w[idx] - '0')) {
                    res = (res + dfs(w, idx + 1, l, r, u + 1)) % MOD;
                }
                break;
            case 5:
                res = (res + dfs(w, idx + 1, l, r, u)) % MOD;
        }
        seen[idx][l][r][u] = true;
        return dp[idx][l][r][u] = res;
    }
}
