package leetcode.biweekly_contests.biweekly_100_199.biweekly_155;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    public int[] baseUnitConversions(int[][] conversions) {
        final int n = conversions.length + 1;
        final int[][][] g = packG(n, conversions);
        final Deque<int[]> dq = new ArrayDeque<>();
        final int[] d = new int[n];
        Arrays.fill(d, (int) 2e9);
        d[0] = 1;
        dq.offer(new int[] { 0, 1 });
        while (!dq.isEmpty()) {
            final int[] top = dq.removeFirst();
            final int u = top[0];
            for (int[] v : g[u]) {
                final long w = ((long) top[1] * v[1]) % MOD;
                if (w < d[v[0]]) {
                    d[v[0]] = (int) w;
                    dq.offerLast(new int[] { v[0], (int) w });
                }
            }
        }
        return d;
    }

    private static int[][][] packG(int n, int[][] edges) {
        final int[][][] g = new int[n][][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]][2];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
        }
        return g;
    }
}
