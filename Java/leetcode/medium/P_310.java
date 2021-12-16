package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("AccessStaticViaInstance")
public class P_310 {

    public List<Integer> findMinHeightTreesTP(int n, int[][] edges) {
        final int[] inDegrees = new int[n];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            inDegrees[u]++;
            inDegrees[v]++;
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] <= 1) {
                q.offerLast(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                remaining--;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (--inDegrees[next] == 1) {
                        q.offerLast(next);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] dp;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        g = packG();
        dp = new int[n];
        final int[] bfs1 = bfs(0);
        dp = new int[n];
        final int[] bfs2 = bfs(bfs1[0]);
        bfs(bfs2[0]);
        final List<Integer> res = new ArrayList<>();
        int diam = 0;
        for (int i = 0; i < n; i++) {
            diam = Math.max(diam, dp[i]);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == ((diam + 1) / 2)) {
                res.add(i);
            }
        }
        return res;
    }

    private static int[] bfs(int u) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int[] res = { -1, -1 };
        dq.offerLast(new int[] { u, -1 });
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int node = curr[0];
                final int par = curr[1];
                res[0] = node;
                res[1] = level;
                dp[node] = Math.max(dp[node], level);
                for (int v : g[node]) {
                    if (v != par) {
                        dq.offerLast(new int[] { v, node });
                    }
                }
            }
        }
        return res;
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
