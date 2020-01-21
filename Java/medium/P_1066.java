package medium;

public class P_1066 {

    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(workers, bikes, 0, 0, new Integer[1 << bikes.length]);
    }

    private static int dfs(int[][] workers, int[][] bikes, int used, int start, Integer[] dp) {
        if (start == workers.length) {
            return 0;
        }
        if (dp[used] != null) {
            return dp[used];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((used & (1 << i)) == 0) {
                used |= 1 << i;
                final int dist = Math.abs(workers[start][0] - bikes[i][0])
                                 + Math.abs(workers[start][1] - bikes[i][1]);
                min = Math.min(min, dist + dfs(workers, bikes, used, start + 1, dp));
                used &= ~(1 << i);
            }
        }
        return dp[used] = min;
    }
}
