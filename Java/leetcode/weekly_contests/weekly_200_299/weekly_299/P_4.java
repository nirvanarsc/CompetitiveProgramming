package leetcode.weekly_contests.weekly_200_299.weekly_299;

import java.util.Arrays;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] subtree;
    static int[] l;
    static int[] r;
    static int time;

    @SuppressWarnings("SuspiciousNameCombination")
    public int minimumScore(int[] nums, int[][] e) {
        n = nums.length;
        edges = e;
        g = packG();
        l = new int[n];
        r = new int[n];
        subtree = nums;
        time = 0;
        dfs(0, -1);
        int res = (int) 1e9;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = subtree[i];
                int y = subtree[j];
                if (isAncestor(i, j)) {
                    x ^= y;
                } else if (isAncestor(j, i)) {
                    y ^= x;
                }
                final int z = subtree[0] ^ x ^ y;
                final int[] sorted = { x, y, z };
                Arrays.sort(sorted);
                res = Math.min(res, sorted[2] - sorted[0]);
            }
        }
        return res;
    }

    private static void dfs(int u, int p) {
        l[u] = time++;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
                subtree[u] ^= subtree[v];
            }
        }
        r[u] = time;
    }

    private static boolean isAncestor(int u, int v) {
        return l[u] <= l[v] && r[v] <= r[u];
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
