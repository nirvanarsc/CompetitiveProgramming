package leetcode.biweekly_contests.biweekly_0_99.biweekly_93;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_2 {

    static int n;
    static int[][] edges;
    static int[][] g;

    public int maxStarSum(int[] vals, int[][] e, int k) {
        n = vals.length;
        edges = e;
        g = packG();
        int res = (int) -1e9;
        for (int u = 0; u < n; u++) {
            final List<Integer> list = new ArrayList<>();
            for (int v : g[u]) {
                list.add(vals[v]);
            }
            list.sort(Comparator.reverseOrder());
            int curr = vals[u];
            int best = curr;
            for (int i = 0; i < Math.min(list.size(), k); i++) {
                curr += list.get(i);
                best = Math.max(best, curr);
            }
            res = Math.max(res, best);
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
