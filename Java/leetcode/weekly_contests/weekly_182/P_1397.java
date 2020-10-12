package leetcode.weekly_contests.weekly_182;

public class P_1397 {

    private static final int MOD = (int) (1e9 + 7);

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        return (int) dfs(0, 0, 1, 1, s1, s2, evil, kmp(evil), new Long[n][evil.length()][2][2]);
    }

    private static long dfs(int i, int j, int eq1, int eq2, String s1, String s2,
                            String evil, int[] kmp, Long[][][][] dp) {
        if (j == evil.length()) { return 0; }
        if (i == s1.length()) { return 1; }
        if (dp[i][j][eq1][eq2] != null) { return dp[i][j][eq1][eq2]; }

        long res = 0L;
        for (char c = 'a'; c <= 'z'; c++) {
            int nj = j;
            if (c == evil.charAt(j)) {
                nj = j + 1;
            } else {
                while (nj > 0 && evil.charAt(nj) != c) {
                    nj = kmp[nj - 1];
                }
                if (evil.charAt(nj) == c) {
                    nj++;
                }
            }
            final int neq1 = c > s1.charAt(i) ? 0 : 1;
            final int neq2 = c < s2.charAt(i) ? 0 : 1;
            if (eq1 == 0 && eq2 == 0) {
                res = (res + dfs(i + 1, nj, 0, 0, s1, s2, evil, kmp, dp)) % MOD;
            } else if (eq1 == 1 && eq2 == 1 && c >= s1.charAt(i) && c <= s2.charAt(i)) {
                res = (res + dfs(i + 1, nj, neq1, neq2, s1, s2, evil, kmp, dp)) % MOD;
            } else if (eq1 == 1 && eq2 == 0 && c >= s1.charAt(i)) {
                res = (res + dfs(i + 1, nj, neq1, 0, s1, s2, evil, kmp, dp)) % MOD;
            } else if (eq1 == 0 && eq2 == 1 && c <= s2.charAt(i)) {
                res = (res + dfs(i + 1, nj, 0, neq2, s1, s2, evil, kmp, dp)) % MOD;
            }
        }
        return dp[i][j][eq1][eq2] = res;
    }

    private static int[] kmp(String s) {
        final int n = s.length();
        final int[] prefixSuffix = new int[n];

        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
        }

        return prefixSuffix;
    }
}
