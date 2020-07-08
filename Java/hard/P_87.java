package hard;

import java.util.Arrays;

public class P_87 {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        final int n = s1.length();
        final int[] count = new int[256];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        if (!Arrays.equals(count, new int[256])) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScrambleTopDown(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        final int n = s1.length();
        return dfs(s1, s2, 0, n - 1, 0, n - 1, new Boolean[n][n][n]);
    }

    private static boolean dfs(String s1, String s2, int l1, int r1, int l2, int r2, Boolean[][][] dp) {
        if (l1 == r1) {
            return s1.charAt(l1) == s2.charAt(l2);
        }
        if (dp[l1][l2][r1 - l1] != null) {
            return dp[l1][l2][r1 - l1];
        }
        if (s1.substring(l1, r1 + 1).equals(s2.substring(l2, r2 + 1))) {
            dp[l1][l2][r1 - l1] = true;
            return true;
        }
        boolean res = false;
        for (int i = 0; i < r1 - l1; i++) {
            final int left1 = l1 + i;
            final int left2 = l2 + i;
            final int right1 = r2 - i;
            final int right2 = l2 + r1 - l1 - i - 1;
            res = dfs(s1, s2, l1, left1, l2, left2, dp) && dfs(s1, s2, left1 + 1, r1, left2 + 1, r2, dp);
            res |= dfs(s1, s2, l1, left1, right1, r2, dp) && dfs(s1, s2, left1 + 1, r1, l2, right2, dp);
            if (res) {
                break;
            }
        }
        return dp[l1][l2][r1 - l1] = res;
    }
}
