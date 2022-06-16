package leetcode.medium;

public final class P_5 {

    public String longestPalindromeDP(String s) {
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

    public String longestPalindrome(String s) {
        int best = 0;
        int start = -1;
        int end = -1;
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && w[l] == w[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > best) {
                best = r - l - 1;
                start = l + 1;
                end = r - 1;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && w[l] == w[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > best) {
                best = r - l - 1;
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end + 1);
    }
}
