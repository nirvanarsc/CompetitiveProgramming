package biweekly_contests.biweekly_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1245 {

    public int treeDiameter(int[][] edges) {
        final boolean[] visited = new boolean[edges.length + 1];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.putIfAbsent(e[0], new ArrayList<>());
            g.putIfAbsent(e[1], new ArrayList<>());
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        final int[] diameter = { 0 };
        dfs(g, visited, 0, diameter);
        return diameter[0];
    }

    private static int dfs(Map<Integer, List<Integer>> g, boolean[] visited, int i, int[] diameter) {
        visited[i] = true;
        int max_depth = 0;
        for (int j : g.get(i)) {
            if (!visited[j]) {
                final int depth = dfs(g, visited, j, diameter);
                diameter[0] = Math.max(diameter[0], depth + max_depth);
                max_depth = Math.max(depth, max_depth);
            }
        }
        return max_depth + 1;
    }
}
