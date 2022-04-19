package leetcode.weekly_contests.weekly_289;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static char[] w;
    static int res;

    public int longestPath(int[] parent, String s) {
        n = parent.length;
        w = s.toCharArray();
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { parent[i], i };
        }
        g = packG();
        res = 0;
        dfs(0);
        return res;
    }

    private static int dfs(int u) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : g[u]) {
            final int curr = dfs(v);
            if (w[u] != w[v]) {
                pq.offer(curr);
            }
        }
        final int big1 = pq.isEmpty() ? 0 : pq.remove();
        final int big2 = pq.isEmpty() ? 0 : pq.remove();
        res = Math.max(res, big1 + big2 + 1);
        return big1 + 1;
    }

    private static int[][] packG() {
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
