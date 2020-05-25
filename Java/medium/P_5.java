package medium;

public final class P_5 {

    public String longestPalindrome(String s) {
        final boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]);
                if (dp[i][j] && i - j + 1 > maxL) {
                    start = j;
                    maxL = i - j + 1;
                }
            }
        }
        return s.substring(start, start + maxL);
    }

    public String longestPalindromeSpace(String s) {
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
}
