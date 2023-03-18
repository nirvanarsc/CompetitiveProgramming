package leetcode.biweekly_contests.biweekly_0_99.biweekly_1;

public class P_1066 {

    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(workers, bikes, 0, 0, new Integer[1 << bikes.length]);
    }

    private static int dfs(int[][] w, int[][] b, int idx, int used, Integer[] dp) {
        if (idx == w.length) { return 0; }
        if (dp[used] != null) { return dp[used]; }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            if ((used & (1 << i)) != 0) { continue; }
            res = Math.min(res, Math.abs(w[idx][0] - b[i][0]) + Math.abs(w[idx][1] - b[i][1])
                                + dfs(w, b, idx + 1, used | (1 << i), dp));
        }
        return dp[used] = res;
    }
}
