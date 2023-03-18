package leetcode.biweekly_contests.biweekly_0_99.biweekly_38;

public class P_1639 {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String[] words, String target) {
        final int n = words[0].length();
        final int[][] counts = new int[n][26];
        for (int j = 0; j < 26; j++) {
            final char c = (char) ('a' + j);
            for (int i = 0; i < n; i++) {
                for (String word : words) {
                    if (word.charAt(i) == c) {
                        counts[i][j]++;
                    }
                }
            }
        }
        return dfs(counts, 0, 0, target, new Integer[target.length()][n]);
    }

    private static int dfs(int[][] words, int i, int j, String target, Integer[][] dp) {
        if (i == target.length()) {
            return 1;
        }
        if (j >= words.length) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        long res = dfs(words, i, j + 1, target, dp);
        final long add = ((long) words[j][target.charAt(i) - 'a'] * dfs(words, i + 1, j + 1, target, dp)) % MOD;
        res = (res + add) % MOD;
        return dp[i][j] = (int) res;
    }
}
