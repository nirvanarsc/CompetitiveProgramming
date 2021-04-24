package leetcode.weekly_contests.weekly_154;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1192 {

    static int n;
    static int time;
    static boolean[] seen;
    static int[] in;
    static int[] low;
    static List<List<Integer>> bridges;
    static List<List<Integer>> edges;
    static int[][] g;

    // Find bridges - dfs tree
    // https://cp-algorithms.com/graph/bridge-searching.html
    public List<List<Integer>> criticalConnections(int nodes, List<List<Integer>> connections) {
        n = nodes;
        seen = new boolean[n];
        in = new int[n];
        low = new int[n];
        bridges = new ArrayList<>();
        edges = connections;
        g = packG();
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(i, -1);
            }
        }
        return bridges;
    }

    private static void dfs(int u, int v) {
        seen[u] = true;
        in[u] = low[u] = time++;
        for (int next : g[u]) {
            if (next == v) {
                continue;
            }
            if (seen[next]) {
                low[u] = Math.min(low[u], in[next]);
            } else {
                dfs(next, u);
                low[u] = Math.min(low[u], low[next]);
                if (low[next] > in[u]) {
                    bridges.add(Arrays.asList(u, next));
                }
            }
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (List<Integer> edge : edges) {
            ++size[edge.get(0)];
            ++size[edge.get(1)];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (List<Integer> edge : edges) {
            g[edge.get(0)][--size[edge.get(0)]] = edge.get(1);
            g[edge.get(1)][--size[edge.get(1)]] = edge.get(0);
        }
        return g;
    }
}
