package leetcode.weekly_contests.weekly_276;

public class P_3 {

    static boolean[] seen;
    static long[] dp;

    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        seen = new boolean[n];
        dp = new long[n];
        return dfs(questions, 0);
    }

    private static long dfs(int[][] q, int idx) {
        if (idx >= q.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        long res = 0;
        res = Math.max(res, dfs(q, idx + 1));
        res = Math.max(res, q[idx][0] + dfs(q, 1 + idx + q[idx][1]));
        seen[idx] = true;
        return dp[idx] = res;
    }
}
