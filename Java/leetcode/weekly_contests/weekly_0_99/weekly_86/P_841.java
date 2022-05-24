package leetcode.weekly_contests.weekly_0_99.weekly_86;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_841 {

    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        final int n = rooms.size();
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(0));
        final boolean[] seen = new boolean[n];
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            if (seen[curr]) {
                continue;
            }
            seen[curr] = true;
            for (int key : rooms.get(curr)) {
                q.offerLast(key);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int n = rooms.size();
        final boolean[] seen = new boolean[n];
        dfs(0, rooms, seen);
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int u, List<List<Integer>> g, boolean[] seen) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int v : g.get(u)) {
            dfs(v, g, seen);
        }
    }
}
