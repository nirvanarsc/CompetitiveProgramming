package leetcode.weekly_contests.weekly_400_499.weekly_426;

public class P_3 {

    static int curr;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        final int n = edges1.length + 1;
        final int m = edges2.length + 1;
        final int[][] g1 = packG(n, edges1);
        final int[][] g2 = packG(m, edges2);
        int add = -1;
        for (int i = 0; i < m; i++) {
            curr = 0;
            dfs(i, -1, 0, k - 1, g2);
            add = Math.max(add, curr);
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            curr = 0;
            dfs(i, -1, 0, k, g1);
            res[i] = curr + add;
        }
        return res;
    }

    private static void dfs(int u, int p, int d, int k, int[][] g) {
        if (d > k) {
            return;
        }
        curr++;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, d + 1, k, g);
            }
        }
    }

    private static int[][] packG(int n, int[][] edges) {
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
