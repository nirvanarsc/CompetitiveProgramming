package leetcode.weekly_contests.weekly_400_499.weekly_453;

public class P_4 {

    public int minOperations(String word1, String word2) {
        final int n = word1.length();
        final char[] l = word1.toCharArray();
        final char[] r = word2.toCharArray();
        final int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = (int) 1e9;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][i] == (int) 1e9) {
                    continue;
                }
                final int costNormal = f(l, r, i, j, false);
                final int costReverse = f(l, r, i, j, true) + 1;
                dp[j + 1][j + 1] = Math.min(dp[j + 1][j + 1], dp[i][i] + Math.min(costNormal, costReverse));
            }
        }
        return dp[n][n];
    }

    private static int f(char[] l, char[] r, int from, int to, boolean isReversed) {
        int res = 0;
        final int[][] freq = new int[26][26];
        for (int i = from, j = isReversed ? to : from; i <= to; i++, j += isReversed ? -1 : 1) {
            if (l[i] != r[j]) {
                final char wanted = l[i];
                final char got = r[j];
                if (freq[got - 'a'][wanted - 'a'] > 0) {
                    freq[got - 'a'][wanted - 'a']--;
                } else {
                    freq[wanted - 'a'][got - 'a']++;
                    res++;
                }
            }
        }
        return res;
    }
}
