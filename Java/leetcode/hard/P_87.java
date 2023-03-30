package leetcode.hard;

public class P_87 {

    static int n;
    static char[] l;
    static char[] r;
    static boolean[][][] seen;
    static boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {
        n = s1.length();
        l = s1.toCharArray();
        r = s2.toCharArray();
        seen = new boolean[n][n][n];
        dp = new boolean[n][n][n];
        return dfs(0, n - 1, 0, n - 1);
    }

    private static boolean dfs(int l1, int r1, int l2, int r2) {
        if (l1 == r1) {
            return l[l1] == r[l2];
        }
        if (seen[l1][l2][r1 - l1]) {
            return dp[l1][l2][r1 - l1];
        }
        if (equals(l1, r1 + 1, l2, r2 + 1)) {
            seen[l1][l2][r1 - l1] = true;
            return dp[l1][l2][r1 - l1] = true;
        }
        boolean res = false;
        for (int i = 0; i < r1 - l1; i++) {
            final int left1 = l1 + i;
            final int left2 = l2 + i;
            final int right1 = r2 - i;
            final int right2 = l2 + r1 - l1 - i - 1;
            res = dfs(l1, left1, l2, left2) && dfs(left1 + 1, r1, left2 + 1, r2);
            res |= dfs(l1, left1, right1, r2) && dfs(left1 + 1, r1, l2, right2);
            if (res) {
                break;
            }
        }
        seen[l1][l2][r1 - l1] = true;
        return dp[l1][l2][r1 - l1] = res;
    }

    private static boolean equals(int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i < r1 && j < r2; i++, j++) {
            if (l[i] != r[j]) {
                return false;
            }
        }
        return true;
    }
}
