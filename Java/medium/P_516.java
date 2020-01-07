package medium;

public final class P_516 {

    public static int longestPalindromeSubseq(String s) {
        final int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[s.length() - 1][0];
    }

    public static int longestPalindromeSpace(String s) {
        final char[] c = s.toCharArray();
        final int[] dp = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            dp[i] = 1;
            int maxSoFar = 0;
            for (int j = i - 1; j >= 0; j--) {
                final int prev = dp[j];
                if (c[i] == c[j]) {
                    dp[j] = maxSoFar + 2;
                }
                maxSoFar = Math.max(prev, maxSoFar);
            }
        }
        int max = 0;
        for (int i : dp) { max = Math.max(max, i); }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("axbdba"));
        System.out.println(longestPalindromeSubseq("bbbab"));

        System.out.println(longestPalindromeSpace("axbdba"));
        System.out.println(longestPalindromeSpace("bbbab"));
    }

    private P_516() {}
}
