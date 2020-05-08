package weekly_contests.weekly_146;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1129 {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        final int[] res = new int[n];
        final Map<Integer, List<Integer>> red = new HashMap<>();
        final Map<Integer, List<Integer>> blue = new HashMap<>();
        for (int[] edge : red_edges) { red.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]); }
        for (int[] edge : blue_edges) { blue.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]); }
        final int[][] paths = new int[2][n];
        Arrays.fill(paths[0], Integer.MAX_VALUE);
        Arrays.fill(paths[1], Integer.MAX_VALUE);
        paths[0][0] = 0;
        paths[1][0] = 0;
        bfs(red, blue, paths);
        for (int i = 0; i < n; i++) {
            final int curr = Math.min(paths[0][i], paths[1][i]);
            res[i] = (curr == Integer.MAX_VALUE) ? -1 : curr;
        }
        return res;
    }

    private static void bfs(Map<Integer, List<Integer>> red, Map<Integer, List<Integer>> blue, int[][] paths) {
        final Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] { 0, 0 });
        q.offerLast(new int[] { 0, 1 });
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                final int[] node = q.removeFirst();
                final int color = node[1];
                final int val = node[0];
                final Map<Integer, List<Integer>> currLevel = color == 1 ? red : blue;
                for (int next : currLevel.getOrDefault(val, Collections.emptyList())) {
                    if (paths[1 - color][next] == Integer.MAX_VALUE) {
                        paths[1 - color][next] = 1 + paths[color][val];
                        q.offerLast(new int[] { next, 1 - color });
                    }
                }
            }
        }
    }
}
