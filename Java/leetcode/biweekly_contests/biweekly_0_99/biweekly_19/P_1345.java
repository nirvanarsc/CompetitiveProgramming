package leetcode.biweekly_contests.biweekly_0_99.biweekly_19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1345 {

    public int minJumps(int[] arr) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        final int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], val -> new ArrayList<>()).add(i);
        }
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        final Set<Integer> skips = new HashSet<>();
        final boolean[] visited = new boolean[n];
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                if (curr == n - 1) {
                    return level;
                }
                if (!visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offerLast(curr + 1);
                }
                if (curr > 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offerLast(curr - 1);
                }
                if (skips.add(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (next != curr && !visited[next]) {
                            visited[next] = true;
                            q.offerLast(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
