package weekly_contests.weekly_154;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1192 {

    int time;

    // Tarjan's strongly connected components algorithm
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final List<Integer>[] graph = buildGraph(n, connections);
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

    // Find Bridges and Articulation points DFS https://www.youtube.com/watch?v=aZXi1unBdJA
    public List<List<Integer>> criticalConnectionsW(int n, List<List<Integer>> connections) {
        final List<Integer>[] graph = buildGraph(n, connections);
        final int[] low = new int[n]; // records the lowest vertex i can reach
        final int[] disc = new int[n]; // records the time i was discovered
        final boolean[] visited = new boolean[n];
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(disc, low, visited, 0, -1, graph, res);
            }
        }
        return res;
    }

    private void dfs(int[] disc,
                     int[] low,
                     boolean[] visited,
                     int curr,
                     int parent,
                     List<Integer>[] g,
                     List<List<Integer>> res) {
        visited[curr] = true;
        disc[curr] = low[curr] = ++time;
        for (int neighbour : g[curr]) {
            if (neighbour != parent) {
                if (!visited[neighbour]) {
                    dfs(disc, low, visited, neighbour, curr, g, res);
                    low[curr] = Math.min(low[curr], low[neighbour]);
                    if (disc[curr] < low[neighbour]) {
                        res.add(Arrays.asList(curr, neighbour));
                    }
                } else {
                    low[curr] = Math.min(low[curr], disc[neighbour]);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
        final List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) { graph[i] = new ArrayList<>(); }
        for (List<Integer> e : connections) {
            final int from = e.get(0);
            final int to = e.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
