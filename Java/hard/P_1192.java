package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1192 {

    int time;

    @SuppressWarnings("unchecked")
    // Tarjan's strongly connected components algorithm
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) { graph[i] = new ArrayList<>(); }
        for (List<Integer> e : connections) {
            final int from = e.get(0);
            final int to = e.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        final int[] low = new int[n]; // records the lowest vertex i can reach
        final int[] disc = new int[n]; // records the time i was discovered
        final List<List<Integer>> res = new ArrayList<>();
        dfs(disc, low, 0, -1, graph, res);
        return res;
    }

    private void dfs(int[] disc, int[] low, int curr, int parent, List<Integer>[] g, List<List<Integer>> res) {
        if (disc[curr] > 0) { return; }
        disc[curr] = low[curr] = ++time;
        for (int neighbour : g[curr]) {
            if (neighbour != parent) {
                if (disc[neighbour] == 0) {
                    dfs(disc, low, neighbour, curr, g, res);
                }
                low[curr] = Math.min(low[curr], low[neighbour]);
            }
        }
        if (curr != 0 && low[curr] > disc[parent]) {
            res.add(Arrays.asList(parent, curr));
        }
    }
}