package leetcode.weekly_contests.weekly_300_399.weekly_319;

public class P_4 {

    static int n;
    static boolean[] seen;
    static boolean[][] isPalindrome;
    static int[] dp2;

    public int maxPalindromes(String s, int k) {
        n = s.length();
        isPalindrome = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1]);
            }
        }
        seen = new boolean[n];
        dp2 = new int[n];
        return dfs(0, k);
    }

    private static int dfs(int i, int k) {
        if (i == n) {
            return 0;
        }
        if (seen[i]) {
            return dp2[i];
        }
        int res = 0;
        for (int j = i + k - 1; j < n; j++) {
            if (isPalindrome[i][j]) {
                res = Math.max(res, 1 + dfs(j + 1, k));
            }
        }
        res = Math.max(res, dfs(i + 1, k));
        seen[i] = true;
        return dp2[i] = res;
    }
}
