package leetcode.weekly_contests.weekly_210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1617 {

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        final int[] res = new int[n - 1];
        final int m = edges.length;
        for (int mask = 0; mask < (1 << m); mask++) {
            final Map<Integer, List<Integer>> g = new HashMap<>();
            final int[] diam = { 0 };
            final int[] vertexMask = { 0 };
            int root = -1;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    final int u = edges[i][0] - 1;
                    final int v = edges[i][1] - 1;
                    if (root == -1) {
                        root = u;
                    }
                    vertexMask[0] |= 1 << u;
                    vertexMask[0] |= 1 << v;
                    g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                    g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
                }
            }
            dfs(root, -1, diam, vertexMask, g);
            if (vertexMask[0] == 0) {
                res[diam[0] - 1]++;
            }
        }
        return res;
    }

    private static int dfs(int curr, int par, int[] diameter, int[] visited, Map<Integer, List<Integer>> g) {
        int maxDepth = 0;
        visited[0] ^= 1 << curr;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            if (next != par) {
                final int depth = dfs(next, curr, diameter, visited, g);
                diameter[0] = Math.max(diameter[0], depth + maxDepth);
                maxDepth = Math.max(depth, maxDepth);
            }
        }
        return maxDepth + 1;
    }
}
