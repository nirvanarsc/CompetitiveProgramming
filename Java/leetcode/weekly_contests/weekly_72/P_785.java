package leetcode.weekly_contests.weekly_72;

import utils.DataStructures.UnionFind;

public class P_785 {

    enum Color {
        RED,
        BLUE,
    }

    public boolean isBipartite(int[][] graph) {
        final Color[] colors = new Color[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == null && !dfs(graph, i, colors, Color.RED)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int at, Color[] colors, Color color) {
        if (colors[at] != null) {
            return colors[at] == color;
        }
        colors[at] = color;
        for (int n : graph[at]) {
            if (!dfs(graph, n, colors, color == Color.RED ? Color.BLUE : Color.RED)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteUF(int[][] graph) {
        final UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (uf.find(i) == uf.find(graph[i][j])) {
                    return false;
                }
                uf.union(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }
}
