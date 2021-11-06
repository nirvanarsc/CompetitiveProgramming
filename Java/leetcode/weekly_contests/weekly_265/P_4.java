package leetcode.weekly_contests.weekly_265;

public class P_4 {

    static boolean[][][] seen;
    static int[][][] dp;
    static char[] l;
    static char[] r;
    static int n;
    static int m;

    public boolean possiblyEquals(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        seen = new boolean[n + 1][m + 1][2000];
        dp = new int[n + 1][m + 1][2000];
        l = s1.toCharArray();
        r = s2.toCharArray();
        return dfs(0, 0, 0) == 1;
    }

    private static int dfs(int i, int j, int diff) {
        if (i == n && j == m) {
            return diff == 0 ? 1 : 0;
        }
        if (seen[i][j][diff + 1000]) {
            return dp[i][j][diff + 1000];
        }
        int res = 0;
        if (i < n && j < m && diff == 0 && l[i] == r[j]) {
            res = Math.max(res, dfs(i + 1, j + 1, 0));
        }
        if (i < n && !isDigit(l[i]) && diff > 0) {
            res = Math.max(res, dfs(i + 1, j, diff - 1));
        }
        if (j < m && !isDigit(r[j]) && diff < 0) {
            res = Math.max(res, dfs(i, j + 1, diff + 1));
        }
        for (int k = i, val = 0; k < n && isDigit(l[k]); k++) {
            val = val * 10 + (l[k] - '0');
            res = Math.max(res, dfs(k + 1, j, diff - val));
        }
        for (int k = j, val = 0; k < m && isDigit(r[k]); k++) {
            val = val * 10 + (r[k] - '0');
            res = Math.max(res, dfs(i, k + 1, diff + val));
        }
        seen[i][j][diff + 1000] = true;
        return dp[i][j][diff + 1000] = res;
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
}
