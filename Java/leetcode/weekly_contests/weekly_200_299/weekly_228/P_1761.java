package leetcode.weekly_contests.weekly_200_299.weekly_228;

public class P_1761 {

    public int minTrioDegree(int n, int[][] edges) {
        final int[] inDeg = new int[n];
        final boolean[][] adj = new boolean[n][n];
        for (int[] e : edges) {
            final int u = e[0] - 1;
            final int v = e[1] - 1;
            adj[u][v] = adj[v][u] = true;
            inDeg[u]++;
            inDeg[v]++;
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (adj[i][j] && adj[j][k] && adj[k][i]) {
                        res = Math.min(res, inDeg[i] + inDeg[j] + inDeg[k] - 6);
                    }
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
