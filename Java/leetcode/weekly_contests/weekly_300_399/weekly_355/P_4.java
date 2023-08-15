package leetcode.weekly_contests.weekly_300_399.weekly_355;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    static int n;
    static int[][] g;
    static int[][] edges;
    static int[] masks;
    static char[] w;
    static Map<Integer, Integer> f;

    public long countPalindromePaths(List<Integer> parent, String s) {
        w = s.toCharArray();
        n = parent.size();
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { i, parent.get(i) };
        }
        g = packG();
        f = new HashMap<>();
        masks = new int[n];
        dfs(0, 0, -1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            final int m = masks[i];
            res += f.merge(m, -1, Integer::sum);
            for (int j = 0; j < 26; j++) {
                res += f.getOrDefault(m ^ (1 << j), 0);
            }
        }
        return res;
    }

    private static void dfs(int mask, int u, int p) {
        mask ^= 1 << (w[u] - 'a');
        masks[u] = mask;
        f.merge(mask, 1, Integer::sum);
        for (int v : g[u]) {
            if (v != p) {
                dfs(mask, v, u);
            }
        }
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
