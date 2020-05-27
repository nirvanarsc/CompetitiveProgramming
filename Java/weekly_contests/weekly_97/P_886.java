package weekly_contests.weekly_97;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.UnionFind;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_886 {

    enum Color {
        RED, BLUE
    }

    public boolean possibleBipartitionDFS(int N, int[][] dislikes) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : dislikes) {
            g.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            g.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        final Color[] colors = new Color[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == null && !dfs(g, i + 1, Color.RED, colors)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> g, int curr, Color c, Color[] visited) {
        if (visited[curr - 1] != null) {
            return visited[curr - 1] == c;
        }
        visited[curr - 1] = c;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            if (!dfs(g, next, c == Color.RED ? Color.BLUE : Color.RED, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        final UnionFind uf = new UnionFind(2 * N + 1);
        for (int[] edge : dislikes) {
            uf.union(edge[0], edge[1] + N);
            uf.union(edge[1], edge[0] + N);
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            }
        }
        for (int i = 1; i <= N; ++i) {
            if (uf.find(i) == uf.find(i + N)) {
                return false;
            }
        }
        return true;
    }
}
