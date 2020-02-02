package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1136 {

    public int minimumSemesters(int n, int[][] relations) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] inDegree = new int[n + 1];
        for (int[] r : relations) {
            g.computeIfAbsent(r[0], l -> new ArrayList<>());
            g.get(r[0]).add(r[1]);
            ++inDegree[r[1]];
        }
        int res = 0;
        int completed = 0;
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                completed++;
                final Integer curr = q.removeFirst();
                if (g.containsKey(curr)) {
                    for (int course : g.remove(curr)) {
                        if (--inDegree[course] == 0) {
                            q.offerLast(course);
                        }
                    }
                }
            }
            res++;
        }
        return completed == n ? res : -1;
    }
}
