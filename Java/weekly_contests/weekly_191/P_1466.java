package weekly_contests.weekly_191;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1466 {

    public int minReorder(int n, int[][] connections) {
        final Set<String> set = new HashSet<>();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] c : connections) {
            g.computeIfAbsent(c[0], v -> new ArrayList<>()).add(c[1]);
            g.computeIfAbsent(c[1], v -> new ArrayList<>()).add(c[0]);
            set.add(c[0] + " " + c[1]);
        }
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(new int[] { 0, -1 }));
        final Set<Integer> visited = new HashSet<>(Collections.singleton(0));
        int res = 0;
        while (!q.isEmpty()) {
            final int[] ints = q.removeFirst();
            if (ints[1] != -1 && !set.contains(ints[0] + " " + ints[1])) {
                res++;
            }
            for (int next : g.getOrDefault(ints[0], Collections.emptyList())) {
                if (visited.add(next)) {
                    q.offerLast(new int[] { next, ints[0] });
                }
            }
        }
        return res;
    }
}
