package leetcode.biweekly_contests.biweekly_0_99.biweekly_5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1136 {

    public int minimumSemesters(int n, int[][] relations) {
        final int[] inDegrees = new int[n + 1];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], v -> new ArrayList<>()).add(r[1]);
            inDegrees[r[1]]++;
        }
        int level = 0;
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; t--) {
                final Integer curr = q.removeFirst();
                for (Integer next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (--inDegrees[next] == 0) {
                        q.offerLast(next);
                    }
                }
                n--;
            }
            level++;
        }
        return n == 0 ? level : -1;
    }
}
