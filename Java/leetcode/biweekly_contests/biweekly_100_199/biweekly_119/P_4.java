package leetcode.biweekly_contests.biweekly_100_199.biweekly_119;

public class P_4 {

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            final int[][] g = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        g[i][j] = (int) 1e9;
                    }
                }
            }
            for (int[] r : roads) {
                if ((mask & (1 << r[0])) != 0 && (mask & (1 << r[1])) != 0) {
                    final int u = r[0];
                    final int v = r[1];
                    final int w = r[2];
                    g[u][v] = Math.min(g[u][v], w);
                    g[v][u] = Math.min(g[v][u], w);
                }
            }
            final int[][] fw = floydWarshall(g, n);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << i)) != 0 && (mask & (1 << j)) != 0) {
                        if (fw[i][j] > maxDistance) {
                            ok = false;
                        }
                    }
                }
            }
            res += ok ? 1 : 0;
        }
        return res;
    }

    // Floyd-Warshall O(n^3)
    private static int[][] floydWarshall(int[][] g, int n) {
        final int[][] d = g.clone();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        return d;
    }
}
