package leetcode.weekly_contests.weekly_264;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] inDegree = new int[n];
        for (int[] e : relations) {
            final int u = e[0] - 1;
            final int v = e[1] - 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }
        final int[] d = new int[n];
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                dq.offerLast(i);
                d[i] = time[i];
            }
        }
        while (!dq.isEmpty()) {
            for (int size = dq.size(); size > 0; size--) {
                final int u = dq.removeFirst();
                for (int v : g.getOrDefault(u, Collections.emptyList())) {
                    d[v] = Math.max(d[v], d[u] + time[v]);
                    if (--inDegree[v] == 0) {
                        dq.offerLast(v);
                    }
                }
            }
        }
        int res = 0;
        for (int num : d) {
            res = Math.max(res, num);
        }
        return res;
    }
}
