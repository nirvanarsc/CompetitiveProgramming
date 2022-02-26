package leetcode.weekly_contests.weekly_87;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_847 {

    public int shortestPathLength(int[][] graph) {
        final int n = graph.length;
        final Deque<int[]> dq = new ArrayDeque<>();
        final boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            seen[i][1 << i] = true;
            dq.add(new int[] { i, 1 << i, 0 });
        }
        while (!dq.isEmpty()) {
            final int[] curr = dq.removeFirst();
            final int u = curr[0];
            final int mask = curr[1];
            final int c = curr[2];
            if (mask == (1 << n) - 1) {
                return c;
            }
            for (int v : graph[u]) {
                final int nextMask = mask | 1 << v;
                if (!seen[v][nextMask]) {
                    seen[v][nextMask] = true;
                    dq.add(new int[] { v, nextMask, c + 1 });
                }
            }
        }
        return -1;
    }
}
