package leetcode.weekly_contests.weekly_100_199.weekly_191;

public class P_1466 {

    static int n;
    static int[][] edges;
    static int[][][] g;

    public int minReorder(int n, int[][] connections) {
        //noinspection AccessStaticViaInstance
        this.n = n;
        edges = new int[2 * (n - 1)][3];
        for (int i = 0; i < (n - 1); i++) {
            final int u = connections[i][0];
            final int v = connections[i][1];
            edges[2 * i] = new int[] { u, v, 1 };
            edges[2 * i + 1] = new int[] { v, u, 0 };
        }
        g = packG();
        return dfs(0, -1);
    }

    private static int dfs(int u, int p) {
        int res = 0;
        for (int[] v : g[u]) {
            if (v[0] != p) {
                res += v[1] + dfs(v[0], u);
            }
        }
        return res;
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
        }
        return g;
    }
}
