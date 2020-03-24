package weekly_contests.weekly_86;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(0));
        final boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        final Set<Integer> keys = new HashSet<>(Collections.singleton(0));
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            if (keys.size() == rooms.size()) {
                return true;
            }
            for (int key : rooms.get(curr)) {
                keys.add(key);
                if (!visited[key]) {
                    visited[key] = true;
                    q.offerLast(key);
                }
            }
        }
        return false;
    }
}
