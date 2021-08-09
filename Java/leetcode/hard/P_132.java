package leetcode.hard;

public class P_132 {

    static boolean[][] isPalindrome;
    static boolean[] seen;
    static int[] dp;

    public int minCut(String s) {
        final int n = s.length();
        isPalindrome = new boolean[n][n];
        seen = new boolean[n];
        dp = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1]);
            }
        }
        return dfs(s.toCharArray(), 0) - 1;
    }

    private static int dfs(char[] w, int idx) {
        if (idx == w.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = (int) 1e9;
        for (int i = idx; i < w.length; i++) {
            if (isPalindrome[idx][i]) {
                res = Math.min(res, 1 + dfs(w, i + 1));
            }
        }
        seen[idx] = true;
        return dp[idx] = res;
    }

    public static int minCutTopDown(String s) {
        final int n = s.length();
        final int[] dp = new int[n];
        final boolean[][] isPalindrome = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            int curr = j;
            for (int i = 0; i <= j; i++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1]);
                if (isPalindrome[i][j]) {
                    curr = i == 0 ? 0 : Math.min(curr, dp[i - 1] + 1);
                }
            }
            dp[j] = curr;
        }
        return dp[n - 1];
    }
}
