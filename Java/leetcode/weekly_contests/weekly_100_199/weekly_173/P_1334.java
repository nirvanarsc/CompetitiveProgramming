package leetcode.weekly_contests.weekly_100_199.weekly_173;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            final int w = e[2];
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        int res = -1;
        int best = (int) 1e9;
        for (int i = 0; i < n; i++) {
            final int[] d = new int[n];
            Arrays.fill(d, (int) 1e9);
            final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
            pq.offer(new int[] { i, 0 });
            while (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                final int u = curr[0];
                final int w = curr[1];
                if (d[u] < w) {
                    continue;
                }
                for (int[] v : g.get(u)) {
                    if (d[v[0]] > w + v[1]) {
                        d[v[0]] = w + v[1];
                        pq.offer(new int[] { v[0], w + v[1] });
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && d[j] <= distanceThreshold) {
                    count++;
                }
            }
            if (best >= count) {
                best = count;
                res = i;
            }
        }
        return res;
    }
}
