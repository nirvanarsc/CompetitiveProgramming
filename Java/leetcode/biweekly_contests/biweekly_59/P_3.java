package leetcode.biweekly_contests.biweekly_59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            final int u = r[0];
            final int v = r[1];
            final int w = r[2];
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[0]));
        pq.offer(new long[] { 0, 0 });
        final long[] d = new long[n];
        final long[] num = new long[n];
        final int[] minf = new int[n];
        final int[] maxf = new int[n];
        final boolean[] seen = new boolean[n];
        Arrays.fill(d, (long) 1e18);
        d[0] = 0;
        num[0] = 1;
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final long w = curr[0];
            final int u = (int) curr[1];
            if (seen[u]) {
                continue;
            }
            seen[u] = true;
            for (int[] next : g.get(u)) {
                final long nextW = w + next[1];
                if (nextW == d[next[0]]) {
                    num[next[0]] = (num[next[0]] + num[u]) % MOD;
                    minf[next[0]] = Math.min(minf[next[0]], minf[u] + 1);
                    maxf[next[0]] = Math.max(maxf[next[0]], maxf[u] + 1);
                    pq.add(new long[] { nextW, next[0] });
                } else if (nextW < d[next[0]]) {
                    d[next[0]] = nextW;
                    num[next[0]] = num[u];
                    minf[next[0]] = minf[u] + 1;
                    maxf[next[0]] = maxf[u] + 1;
                    pq.add(new long[] { nextW, next[0] });
                }
            }
        }
        return (int) num[n - 1];
    }
}
