package leetcode.biweekly_contests.biweekly_80;

public class P_3 {

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        final long[] masks = new long[62];
        for (char[] m : mappings) {
            final int u = f(m[0]);
            final int v = f(m[1]);
            masks[u] |= 1L << v;
        }
        final int n = s.length();
        final int m = sub.length();
        final int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        final char[] l = s.toCharArray();
        final char[] r = sub.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                if (l[i] == r[j] || (masks[f(r[j])] & (1L << f(l[i]))) != 0) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] == 1) {
                return true;
            }
        }
        return false;
    }

    private static int f(char c) {
        final int v;
        if (Character.isUpperCase(c)) {
            v = 26 + c - 'A';
        } else if (Character.isDigit(c)) {
            v = 52 + c - '0';
        } else {
            v = c - 'a';
        }
        return v;
    }
}
