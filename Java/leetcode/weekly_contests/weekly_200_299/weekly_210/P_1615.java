package leetcode.weekly_contests.weekly_200_299.weekly_210;

public class P_1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        final int[] deg = new int[n];
        final int[][] g = new int[n][n];
        for (int[] e : roads) {
            deg[e[0]]++;
            deg[e[1]]++;
            g[e[0]][e[1]] = g[e[1]][e[0]] = 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, deg[i] + deg[j] - g[i][j]);
            }
        }
        return res;
    }
}
