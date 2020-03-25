package weekly_contests.weekly_84;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_835 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        final Map<Integer, Set<Integer>> g = new HashMap<>();
        final int[] res = new int[N];
        final int[] count = new int[N];
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], v -> new HashSet<>()).add(e[1]);
            g.computeIfAbsent(e[1], v -> new HashSet<>()).add(e[0]);
        }
        dfs(0, -1, count, res, g);
        dfs2(0, -1, count, res, g);
        return res;
    }

    public void dfs(int root, int prev, int[] count, int[] res, Map<Integer, Set<Integer>> g) {
        for (int i : g.getOrDefault(root, Collections.emptySet())) {
            if (i == prev) { continue; }
            dfs(i, root, count, res, g);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    public void dfs2(int root, int prev, int[] count, int[] res, Map<Integer, Set<Integer>> g) {
        for (int i : g.getOrDefault(root, Collections.emptySet())) {
            if (i == prev) { continue; }
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root, count, res, g);
        }
    }
}
