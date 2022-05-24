package leetcode.weekly_contests.weekly_200_299.weekly_226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : adjacentPairs) {
            g.computeIfAbsent(p[0], val -> new ArrayList<>()).add(p[1]);
            g.computeIfAbsent(p[1], val -> new ArrayList<>()).add(p[0]);
        }
        int start = -1;
        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            if (e.getValue().size() == 1) {
                start = e.getKey();
                break;
            }
        }
        final Set<Integer> seen = new HashSet<>();
        final List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(start);
            seen.add(start);
            boolean ok = false;
            for (int next : g.get(start)) {
                if (!seen.contains(next)) {
                    start = next;
                    ok = true;
                }
            }
            if (!ok) {
                break;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
