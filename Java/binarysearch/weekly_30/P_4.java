package binarysearch.weekly_30;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public int solve(int[][] connections) {
        final Map<Integer, List<int[]>> g = new HashMap<>();
        int start = 2000;
        int end = 0;
        int maxBus = 0;
        for (int[] e : connections) {
            g.computeIfAbsent(e[0], v -> new ArrayList<>()).add(new int[] { e[1], e[2] + 1 });
            start = Math.min(start, e[0]);
            start = Math.min(start, e[1]);
            end = Math.max(end, e[0]);
            end = Math.max(end, e[1]);
            maxBus = Math.max(maxBus, e[2] + 1);
        }
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, start, 0 });
        final int[][] d = new int[end + 1][maxBus + 1];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        d[start][0] = 0;
        while (!dq.isEmpty()) {
            final int[] curr = dq.remove();
            final int dist = curr[0];
            final int u = curr[1];
            final int bus = curr[2];
            if (d[u][bus] < dist) {
                continue;
            }
            for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
                final int v = next[0];
                final int nextBus = next[1];
                final int switchCost = bus == nextBus ? 0 : 1;
                if (d[v][nextBus] > d[u][bus] + switchCost) {
                    d[v][nextBus] = d[u][bus] + switchCost;
                    // 0-1 BFS
                    // https://cp-algorithms.com/graph/01_bfs.html
                    if (switchCost == 0) {
                        dq.addFirst(new int[] { d[v][nextBus], v, nextBus });
                    } else {
                        dq.addLast(new int[] { d[v][nextBus], v, nextBus });
                    }
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 1; i <= maxBus; i++) {
            res = Math.min(res, d[end][i]);
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
