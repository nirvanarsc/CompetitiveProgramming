package leetcode.biweekly_contests.biweekly_100_199.biweekly_128;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("AccessStaticViaInstance")
public class P_3 {

    static int n;
    static int[][] edges;
    static int[][][] g;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.n = n;
        this.edges = edges;
        g = packG();
        final int[] res = new int[n];
        final long[] d = new long[n];
        Arrays.fill(d, (long) 9e18);
        d[0] = 0;
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            final long[] pop = pq.remove();
            final int u = (int) pop[0];
            final long curr = pop[1];
            if (d[u] < curr) {
                continue;
            }
            for (int[] v : g[u]) {
                final long next = v[1] + curr;
                if (next < d[v[0]] && next < disappear[v[0]]) {
                    d[v[0]] = next;
                    pq.offer(new long[] { v[0], d[v[0]] });
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = d[i] == (long) 9e18 ? -1 : (int) d[i];
        }
        return res;
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
