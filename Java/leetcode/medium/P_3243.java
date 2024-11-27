package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P_3243 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        final int q = queries.length;
        final int[] res = new int[q];
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            if (i < (n - 1)) {
                g.get(i).add(i + 1);
            }
        }
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            g.get(u).add(v);
            res[i] = bfs(n, g);
        }
        return res;
    }

    private static int bfs(int n, List<List<Integer>> g) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final int[] d = new int[n];
        Arrays.fill(d, (int) 1e9);
        d[0] = 0;
        dq.offerLast(0);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int u = dq.removeFirst();
                if (d[u] < level) {
                    continue;
                }
                for (int v : g.get(u)) {
                    if (d[v] > d[u] + 1) {
                        d[v] = d[u] + 1;
                        dq.offerLast(v);
                    }
                }
            }
        }
        return d[n - 1];
    }
}
