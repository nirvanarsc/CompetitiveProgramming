package leetcode.hard;

public class P_44 {

    static boolean[][] seen;
    static int[][] dp;
    static int n;
    static int m;

    public boolean isMatch(String s, String p) {
        p = f(p);
        n = s.length();
        m = p.length();
        seen = new boolean[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0) == 1;
    }

    private static String f(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '*') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static int dfs(char[] l, char[] r, int ll, int rr) {
        if (rr == m) {
            return ll == n ? 1 : 0;
        }
        if (seen[ll][rr]) {
            return dp[ll][rr];
        }
        int res = 0;
        if (r[rr] == '?') {
            if (ll < n) {
                res = Math.max(res, dfs(l, r, ll + 1, rr + 1));
            }
        } else if (r[rr] == '*') {
            for (int i = ll; i <= n; i++) {
                res = Math.max(res, dfs(l, r, i, rr + 1));
            }
        } else if (ll < n && r[rr] == l[ll]) {
            res = dfs(l, r, ll + 1, rr + 1);
        }
        seen[ll][rr] = true;
        return dp[ll][rr] = res;
    }
}
