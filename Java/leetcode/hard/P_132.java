package leetcode.hard;

import java.util.Arrays;

public final class P_132 {

    public static int minCut(String s) {
        final int len = s.length();
        final boolean[][] isPalindrome = new boolean[len][len];
        final int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        return recurse(0, s, dp, isPalindrome) - 1;
    }

    private static int recurse(int start, String s, int[] dp, boolean[][] isPalindrome) {
        if (start == s.length()) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }

        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome[start][i - 1]) {
                res = Math.min(res, 1 + recurse(i, s, dp, isPalindrome));
            }
        }

        return dp[start] = res;
    }

    public static int minCut2(String s) {
        final int len = s.length();
        final int[] cut = new int[len];
        final boolean[][] isPalindrome = new boolean[len][len];

        for (int col = 0; col < len; col++) {
            int min = col;
            for (int row = 0; row <= col; row++) {
                if (s.charAt(row) == s.charAt(col) && (col - row <= 2 || isPalindrome[row + 1][col - 1])) {
                    isPalindrome[row][col] = true;
                    min = row == 0 ? 0 : Math.min(min, cut[row - 1] + 1);
                }
            }
            cut[col] = min;
        }

        return cut[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCut2("abcbad"));
    }

    private P_132() {}
}
