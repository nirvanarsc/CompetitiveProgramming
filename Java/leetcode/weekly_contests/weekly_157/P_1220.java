package leetcode.weekly_contests.weekly_157;

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
}
