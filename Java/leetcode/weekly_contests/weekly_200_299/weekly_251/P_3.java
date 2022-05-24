package leetcode.weekly_contests.weekly_200_299.weekly_251;

public class P_3 {

    static int[][] g;
    static boolean[][] seen;
    static int[][] dp;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        final int n = students.length;
        final int m = students[0].length;
        seen = new boolean[1 << n][n];
        dp = new int[1 << n][n];
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int score = 0;
                for (int k = 0; k < m; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score++;
                    }
                }
                g[i][j] = score;
            }
        }
        return dfs(students, mentors, 0, 0);
    }

    private static int dfs(int[][] s, int[][] m, int mask, int idx) {
        if (idx == s.length) {
            return 0;
        }
        if (seen[mask][idx]) {
            return dp[mask][idx];
        }
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            if ((mask & (1 << i)) == 0) {
                res = Math.max(res, g[idx][i] + dfs(s, m, mask | (1 << i), idx + 1));
            }
        }
        seen[mask][idx] = true;
        return dp[mask][idx] = res;
    }
}
