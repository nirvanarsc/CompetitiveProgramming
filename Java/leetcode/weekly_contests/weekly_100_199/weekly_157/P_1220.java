package leetcode.weekly_contests.weekly_100_199.weekly_157;

public class P_1220 {

    private static final int MOD = (int) (1e9 + 7);

    static int total;
    static boolean[][] seen;
    static int[][] dp;
    static int[][] next = {
            // a e i o u
            { 1, 2, 3, 4, 5 },
            { 2 },
            { 1, 3 },
            { 1, 2, 4, 5 },
            { 3, 5 },
            { 1 }
    };

    public int countVowelPermutation(int n) {
        total = n;
        seen = new boolean[n][7];
        dp = new int[n][7];
        return dfs(0, 0);
    }

    private static int dfs(int idx, int vowel) {
        if (idx == total) {
            return 1;
        }
        if (seen[idx][vowel]) {
            return dp[idx][vowel];
        }
        int res = 0;
        for (int n : next[vowel]) {
            res = (res + dfs(idx + 1, n)) % MOD;
        }
        seen[idx][vowel] = true;
        return dp[idx][vowel] = res;
    }

    public int countVowelPermutationME(int n) {
        final long[][] grid = {
                { 0, 1L, 0, 0, 0 },
                { 1L, 0, 1L, 0, 0 },
                { 1L, 1L, 0, 1L, 1L },
                { 0, 0, 1L, 0, 1L },
                { 1L, 0, 0, 0, 0 }
        };
        long[][] identity = new long[5][5];
        for (int i = 0; i < identity.length; i++) {
            identity[i][i] = 1;
        }
        identity = pow(grid, identity, n - 1);
        long res = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res = (res + identity[i][j]) % MOD;
            }
        }
        return (int) res;
    }

    private static long[][] pow(long[][] m, long[][] answer, long k) {
        while (k > 0) {
            if (k % 2 == 1) {
                answer = multiply(answer, m);
            }
            m = multiply(m, m);
            k >>= 1;
        }
        return answer;
    }

    private static long[][] multiply(long[][] left, long[][] right) {
        final int lRow = left.length;
        final int lCol = left[0].length;
        final int rCol = right[0].length;
        final long[][] res = new long[lRow][rCol];
        for (int i = 0; i < lRow; i++) {
            for (int k = 0; k < lCol; k++) {
                for (int j = 0; j < rCol; j++) {
                    res[i][j] = (res[i][j] + left[i][k] * right[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
