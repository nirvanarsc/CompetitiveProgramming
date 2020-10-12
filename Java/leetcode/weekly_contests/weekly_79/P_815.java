package leetcode.weekly_contests.weekly_79;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_815 {

    public int numBusesToDestinationBFS(int[][] routes, int S, int T) {
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(S));
        final Set<Integer> buses = new HashSet<>();
        final Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int bus : routes[i]) {
                g.computeIfAbsent(bus, v -> new HashSet<>()).add(i);
            }
        }
        for (int level = 0; !q.isEmpty(); level++) {
            for (int k = q.size(); k > 0; k--) {
                final int curr = q.removeFirst();
                if (curr == T) {
                    return level;
                }
                for (int bus : g.getOrDefault(curr, Collections.emptySet())) {
                    if (!buses.contains(bus)) {
                        buses.add(bus);
                        for (int r : routes[bus]) {
                            q.offerLast(r);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
