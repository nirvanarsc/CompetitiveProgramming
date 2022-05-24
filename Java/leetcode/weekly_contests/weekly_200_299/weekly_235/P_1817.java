package leetcode.weekly_contests.weekly_200_299.weekly_235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1817 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        final int[] res = new int[k];
        final Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] log : logs) {
            g.computeIfAbsent(log[0], v -> new HashSet<>()).add(log[1]);
        }
        for (Map.Entry<Integer, Set<Integer>> e : g.entrySet()) {
            res[e.getValue().size() - 1]++;
        }
        return res;
    }
}
