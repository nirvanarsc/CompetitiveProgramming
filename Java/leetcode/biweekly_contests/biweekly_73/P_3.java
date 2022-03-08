package leetcode.biweekly_contests.biweekly_73;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static List<List<Integer>> res;

    @SuppressWarnings("AccessStaticViaInstance")
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        g = packG();
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i);
        }
        return res;
    }

    private static void dfs(int u, int curr) {
        for (int v : g[curr]) {
            if (res.get(v).isEmpty() || res.get(v).get(res.get(v).size() - 1) != u) {
                res.get(v).add(u);
                dfs(u, v);
            }
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }
}
