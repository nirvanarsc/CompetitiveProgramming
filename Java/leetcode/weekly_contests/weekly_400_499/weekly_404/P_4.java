package leetcode.weekly_contests.weekly_400_499.weekly_404;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        final int u = diameter(edges1);
        final int v = diameter(edges2);
        return Math.max(Math.max(u, v), 1 + ((u + 1) / 2) + ((v + 1) / 2));
    }

    private static int diameter(int[][] edges) {
        final int[][] g = packG(edges, edges.length + 1);
        final int[] bfs1 = bfs(0, g);
        final int[] bfs2 = bfs(bfs1[0], g);
        return bfs2[1];
    }

    private static int[] bfs(int u, int[][] g) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int[] res = { -1, -1 };
        dq.offerLast(new int[] { u, -1 });
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int node = curr[0];
                final int par = curr[1];
                res[0] = node;
                res[1] = level;
                for (int next : g[node]) {
                    if (next != par) {
                        dq.offerLast(new int[] { next, node });
                    }
                }
            }
        }
        return res;
    }

    private static int[][] packG(int[][] edges, int n) {
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
