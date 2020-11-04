package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final int[] inDegrees = new int[n];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            inDegrees[u]++;
            inDegrees[v]++;
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] <= 1) {
                q.offerLast(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                remaining--;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (--inDegrees[next] == 1) {
                        q.offerLast(next);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}
