package leetcode.weekly_contests.weekly_260;

public class P_2 {

    public long gridGame(int[][] grid) {
        final int n = grid[0].length;
        final int[] r1 = grid[0];
        final int[] r2 = grid[1];
        final long[] pre1 = new long[n + 1];
        final long[] pre2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre1[i] = pre1[i - 1] + r1[i - 1];
            pre2[i] = pre2[i - 1] + r2[i - 1];
        }
        return f(pre1, pre2, n);
    }

    private static long f(long[] p1, long[] p2, int n) {
        long res = (long) 1e18;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(p1[n] - p1[i], p2[i - 1]));
        }
        return res;
    }
}
