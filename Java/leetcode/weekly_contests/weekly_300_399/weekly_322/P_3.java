package leetcode.weekly_contests.weekly_300_399.weekly_322;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    static int m;
    static int[][] edges;
    static int[][][] g;

    public int minScore(int n, int[][] roads) {
        for (int[] r : roads) {
            r[0]--;
            r[1]--;
        }
        m = n;
        edges = roads;
        g = packG();
        final int[] d = new int[n];
        Arrays.fill(d, (int) 1e9);
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { 0, d[0] });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int c = curr[1];
            if (d[u] < c) {
                continue;
            }
            for (int[] v : g[u]) {
                final int cost = Math.min(d[u], v[1]);
                if (d[v[0]] > cost) {
                    d[v[0]] = cost;
                    pq.offer(new int[] { v[0], d[v[0]] });
                }
            }
        }
        return d[n - 1];
    }

    private static int[][][] packG() {
        final int[][][] g = new int[m][][];
        final int[] size = new int[m];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < m; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
            g[edge[1]][--size[edge[1]]] = new int[] { edge[0], edge[2] };
        }
        return g;
    }
}
