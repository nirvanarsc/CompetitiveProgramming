package binarysearch.weekly_35;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public int[] solve(int[][] lists) {
        int n = 0;
        final Map<Integer, Integer> normalized = new HashMap<>();
        final List<Integer> rev = new ArrayList<>();
        for (int[] list : lists) {
            for (int num : list) {
                if (!normalized.containsKey(num)) {
                    rev.add(num);
                    normalized.put(num, n++);
                }
            }
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] inDeg = new int[n];
        for (int[] list : lists) {
            for (int i = 0; i < list.length - 1; i++) {
                final int u = normalized.get(list[i]);
                final int v = normalized.get(list[i + 1]);
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                inDeg[v]++;
            }
        }
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] res = new int[n];
        int idx = 0;
        while (!dq.isEmpty()) {
            final int curr = dq.removeFirst();
            res[idx++] = rev.get(curr);
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDeg[next] == 0) {
                    dq.offerLast(next);
                }
            }
        }
        return res;
    }
}
