package leetcode.biweekly_contests.biweekly_91;

import java.util.Arrays;

public class P_3 {

    static int n;
    static int[][] g;
    static int[] val;
    static boolean[] isLeaf;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = edges.length + 1;
        g = packG(edges);
        val = amount;
        isLeaf = new boolean[n];
        final int[] a = new int[n];
        final int[] b = new int[n];
        Arrays.fill(b, (int) 1e9);
        dfs1(bob, -1, 0, b);
        dfs2(0, -1, 0, 0, a, b);
        int res = (int) -1e9;
        for (int i = 1; i < n; i++) {
            if (isLeaf[i]) {
                res = Math.max(res, a[i]);
            }
        }
        return res;
    }

    private static boolean dfs1(int u, int p, int t, int[] b) {
        b[u] = t;
        if (u == 0) {
            return true;
        }
        for (int v : g[u]) {
            if (v != p) {
                if (dfs1(v, u, t + 1, b)) {
                    return true;
                }
            }
        }
        b[u] = (int) 1e9;
        return false;
    }

    private static void dfs2(int u, int p, int t, int curr, int[] a, int[] b) {
        if (t < b[u]) {
            curr += val[u];
        } else if (t == b[u]) {
            curr += val[u] / 2;
        }
        a[u] = curr;
        isLeaf[u] = g[u].length == 1;
        for (int v : g[u]) {
            if (v != p) {
                dfs2(v, u, t + 1, curr, a, b);
            }
        }
    }

    private static int[][] packG(int[][] edges) {
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
