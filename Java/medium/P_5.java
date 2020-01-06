package medium;

public final class P_5 {

    public static String longestPalindrome(String s) {
        final boolean[][] dp = new boolean[s.length()][s.length()];
        int palindromeStart = 0;
        int maxLen = 0;

        for (int col = 0; col < s.length(); col++) {
            for (int row = 0; row <= col; row++) {
                if (s.charAt(row) == s.charAt(col) && (col - row < 2 || dp[row + 1][col - 1])) {
                    dp[row][col] = true;
                }

                if (dp[row][col] && (col - row + 1 > maxLen)) {
                    palindromeStart = row;
                    maxLen = col - row + 1;
                }
            }
        }

        return s.substring(palindromeStart, palindromeStart + maxLen);
    }

    public static String longestPalindrome2(String s) {
        if (s.isEmpty()) { return s; }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            final int len1 = expandAroundCenter(s, i, i);
            final int len2 = expandAroundCenter(s, i, i + 1);
            final int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdbbfcba"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome(""));

        System.out.println(longestPalindrome2("abcdbbfcba"));
        System.out.println(longestPalindrome2("cbbd"));
        System.out.println(longestPalindrome2("a"));
        System.out.println(longestPalindrome2("bb"));
        System.out.println(longestPalindrome2("ac"));
        System.out.println(longestPalindrome2(""));
    }

    private P_5() {}
}
