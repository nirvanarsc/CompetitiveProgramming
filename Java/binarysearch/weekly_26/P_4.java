package binarysearch.weekly_26;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] d1;
    static int[] d2;

    public int solve(int[][] e, int u, int v) {
        edges = e;
        n = 0;
        for (int[] ed : e) {
            n = Math.max(n, ed[0]);
            n = Math.max(n, ed[1]);
        }
        n++;
        d1 = new int[n];
        d2 = new int[n];
        g = packG();
        bfs(u, d1);
        bfs(v, d2);
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (d2[i] + 1 < d1[i]) {
                res = Math.max(res, 2 * d1[i] - 1);
            }
        }
        return res;
    }

    private static void bfs(int u, int[] d) {
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { u, -1 });
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int v = curr[0];
                final int p = curr[1];
                d[v] = level;
                for (int next : g[v]) {
                    if (next != p) {
                        dq.offerLast(new int[] { next, v });
                    }
                }
            }
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
