package leetcode.biweekly_contests.biweekly_63;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final int n = patience.length;
        final int[] d = new int[n];
        Arrays.fill(d, (int) 1e9);
        d[0] = 0;
        final Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int curr = dq.removeFirst();
                if (d[curr] < level) {
                    continue;
                }
                d[curr] = level;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    dq.offerLast(next);
                }
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            final int L = d[i] * 2;
            final int lastSent = L - 1 - (L - 1) % patience[i];
            res = Math.max(res, L);
            res = Math.max(res, lastSent + L);
        }
        return res + 1;
    }
}
