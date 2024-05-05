package leetcode.weekly_contests.weekly_300_399.weekly_394;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    static int n;
    static int[][] edges;
    static int[][][] g;

    public boolean[] findAnswer(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        g = packG();
        final long[] l = dijkstra(0);
        final long[] r = dijkstra(n - 1);
        final int q = edges.length;
        final boolean[] res = new boolean[q];
        for (int i = 0; i < q; i++) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            final int w = edges[i][2];
            res[i] = l[u] + r[v] + w == l[n - 1] || l[v] + r[u] + w == l[n - 1];
        }
        return res;
    }

    private static long[] dijkstra(int start) {
        final long[] d = new long[n];
        Arrays.fill(d, (long) 9e18);
        d[start] = 0;
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[] { start, d[start] });
        while (!pq.isEmpty()) {
            final long[] pop = pq.remove();
            final int u = (int) pop[0];
            final long curr = pop[1];
            if (curr < d[u]) {
                continue;
            }
            for (int[] next : g[u]) {
                if (d[next[0]] > curr + next[1]) {
                    d[next[0]] = curr + next[1];
                    pq.offer(new long[] { next[0], d[next[0]] });
                }
            }
        }
        return d;
    }

    private static int[][][] packG() {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
            g[edge[1]][--size[edge[1]]] = new int[] { edge[0], edge[2] };
        }
        return g;
    }
}
