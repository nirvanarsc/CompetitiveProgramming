package leetcode.weekly_contests.weekly_269;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_4 {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        final boolean[] ok = new boolean[n];
        ok[0] = true;
        ok[firstPerson] = true;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        for (int t = 1, i = 0; i < meetings.length; t++) {
            if (meetings[i][2] < t) {
                continue;
            }
            final Map<Integer, List<Integer>> g = new HashMap<>();
            while (i < meetings.length && meetings[i][2] == t) {
                final int u = meetings[i][0];
                final int v = meetings[i][1];
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
                i++;
            }
            final Deque<Integer> dq = new ArrayDeque<>();
            for (int u : g.keySet()) {
                if (ok[u]) {
                    dq.offerLast(u);
                }
            }
            final Set<Integer> seen = new HashSet<>();
            while (!dq.isEmpty()) {
                final int u = dq.removeFirst();
                ok[u] = true;
                seen.add(u);
                for (int v : g.getOrDefault(u, Collections.emptyList())) {
                    if (seen.add(v)) {
                        dq.offerLast(v);
                    }
                }
            }
        }
        final List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (ok[j]) {
                res.add(j);
            }
        }
        return res;
    }
}
