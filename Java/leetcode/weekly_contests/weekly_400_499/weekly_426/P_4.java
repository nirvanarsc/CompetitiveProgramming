package leetcode.weekly_contests.weekly_400_499.weekly_426;

public class P_4 {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        final int n = edges1.length + 1;
        final int m = edges2.length + 1;
        final int[][] g1 = packG(n, edges1);
        final int[][] g2 = packG(m, edges2);
        final int[] size1 = new int[2];
        final int[] size2 = new int[2];
        final int[] map1 = new int[n];
        final int[] map2 = new int[m];
        dfs(0, -1, 0, size1, map1, g1);
        dfs(0, -1, 0, size2, map2, g2);
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = size1[map1[i]] + Math.max(size2[0], size2[1]);
        }
        return res;
    }

    private static void dfs(int u, int p, int d, int[] size, int[] map, int[][] g) {
        size[d]++;
        map[u] = d;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, d ^ 1, size, map, g);
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
