package leetcode.weekly_contests.weekly_264;

public class P_3 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] size;
    static long[] res;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { i, parents[i] };
        }
        g = packG();
        size = new int[n];
        res = new long[n];
        dfs(0, -1);
        dfs2(0, -1);
        long max = 0;
        for (long num : res) {
            max = Math.max(max, num);
        }
        int count = 0;
        for (long num : res) {
            if (num == max) {
                count++;
            }
        }
        return count;
    }

    private static void dfs(int u, int par) {
        size[u] = 1;
        for (int v : g[u]) {
            if (v != par) {
                dfs(v, u);
                size[u] += size[v];
            }
        }
    }

    private static void dfs2(int u, int par) {
        int children = 0;
        res[u] = 1L;
        for (int v : g[u]) {
            if (v != par) {
                children += size[v];
                res[u] *= size[v];
                dfs2(v, u);
            }
        }
        if (n - children > 1) {
            res[u] *= n - children - 1;
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
