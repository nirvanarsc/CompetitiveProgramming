package weekly_contests.weekly_179;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1376 {

    static class Pair {
        int id;
        int time;

        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                g.computeIfAbsent(manager[i], v -> new ArrayList<>()).add(i);
            }
        }
        final Deque<Pair> q = new ArrayDeque<>(Collections.singletonList(new Pair(headID, 0)));
        int res = 0;
        while (!q.isEmpty()) {
            final Pair curr = q.removeFirst();
            res = Math.max(res, curr.time);
            for (int next : g.getOrDefault(curr.id, Collections.emptyList())) {
                q.offerLast(new Pair(next, curr.time + informTime[curr.id]));
            }
        }
        return res;
    }
}
