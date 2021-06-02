package binarysearch.weekly_36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    private static Map<Integer, List<int[]>> g;
    private static Map<Integer, Integer> idx;

    public boolean solve(int[][] lists) {
        g = new HashMap<>();
        idx = new HashMap<>();
        for (int[] edge : lists) {
            final int u = edge[0];
            final int v = edge[1] + 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, edge[2] });
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, edge[2] });
        }
        int n = 0;
        for (int key : g.keySet()) {
            idx.put(key, n++);
        }
        final int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int key : g.keySet()) {
            final int j = idx.get(key);
            if (colors[j] == -1 && !dfs(key, j, 0, colors)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int u, int j, int c, int[] visited) {
        if (visited[j] != -1) {
            return visited[j] == c;
        }
        visited[j] = c;
        for (int[] next : g.getOrDefault(u, Collections.emptyList())) {
            if (!dfs(next[0], idx.get(next[0]), c ^ next[1], visited)) {
                return false;
            }
        }
        return true;
    }
}
