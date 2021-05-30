package leetcode.weekly_contests.weekly_243;

public class P_4 {

    static long[][] dp;
    static boolean[][] seen;

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        dp = new long[n][n];
        seen = new boolean[n][n];
        dfs(dist, speed, 0, 0);
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] * speed <= (long) speed * hoursBefore) {
                return i;
            }
        }
        return -1;
    }

    private static long dfs(int[] d, int speed, int idx, int skips) {
        if (idx == d.length) {
            return 0;
        }
        if (seen[idx][skips]) {
            return dp[idx][skips];
        }
        long res = (long) 1e18;
        int add = 0;
        for (int i = 0; idx + i < d.length; i++) {
            add += d[idx + i];
            res = Math.min(res, (add + speed - 1) / speed + dfs(d, speed, idx + i + 1, skips + i));
        }
        seen[idx][skips] = true;
        return dp[idx][skips] = res;
    }

}
