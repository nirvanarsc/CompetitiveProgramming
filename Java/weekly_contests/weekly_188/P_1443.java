package weekly_contests.weekly_188;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1443 {

    int res;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
        }
        dfs(g, hasApple, 0);
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, List<Boolean> hasApple, int curr) {
        boolean take = hasApple.get(curr);
        for (int n : g.getOrDefault(curr, Collections.emptyList())) {
            take |= dfs(g, hasApple, n);
        }
        if (take && curr != 0) {
            res += 2;
        }
        return take;
    }
}
