package leetcode.weekly_contests.weekly_200_299.weekly_258;

import java.util.HashSet;
import java.util.Set;

public class P_4 {

    private static int n;
    private static int[] values;
    private static int[] res;
    private static int[][] edges;
    private static int[][] g;

    static class Pair {
        Set<Integer> seen;
        int res;

        Pair(Set<Integer> seen, int res) {
            this.seen = seen;
            this.res = res;
        }
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        n = parents.length;
        values = nums;
        res = new int[n];
        edges = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            edges[i - 1] = new int[] { i, parents[i] };
        }
        g = packG();
        dfs(0, -1);
        return res;
    }

    private static Pair dfs(int u, int par) {
        Set<Integer> curr = new HashSet<>();
        curr.add(values[u]);
        int best = 1;
        for (int v : g[u]) {
            if (v != par) {
                final Pair child = dfs(v, u);
                Set<Integer> childSet = child.seen;
                if (curr.size() < childSet.size()) {
                    final Set<Integer> temp = curr;
                    curr = childSet;
                    childSet = temp;
                }
                best = Math.max(best, child.res);
                curr.addAll(childSet);
            }
        }
        while (curr.contains(best)) {
            best++;
        }
        res[u] = best;
        return new Pair(curr, best);
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
