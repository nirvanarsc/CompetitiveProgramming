package leetcode.weekly_contests.weekly_100_199.weekly_146;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1129 {

    static int[][][] g;
    static int[][] d;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        g = new int[][][] { packG(n, redEdges), packG(n, blueEdges) };
        d = new int[2][n];
        Arrays.fill(d[0], (int) 1e9);
        Arrays.fill(d[1], (int) 1e9);
        d[0][0] = d[1][0] = 0;
        bfs();
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int curr = Math.min(d[0][i], d[1][i]);
            res[i] = curr == (int) 1e9 ? -1 : curr;
        }
        return res;
    }

    private static void bfs() {
        final Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] { d[0][0], 0 });
        q.offerLast(new int[] { d[1][0], 1 });
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] node = q.removeFirst();
                final int u = node[0];
                final int color = node[1];
                if (d[color][u] < level) {
                    continue;
                }
                for (int v : g[color][u]) {
                    if (d[1 ^ color][v] > d[color][u] + 1) {
                        d[1 ^ color][v] = d[color][u] + 1;
                        q.offerLast(new int[] { v, 1 ^ color });
                    }
                }
            }
        }
    }

    private static int[][] packG(int n, int[][] edges) {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }
}
