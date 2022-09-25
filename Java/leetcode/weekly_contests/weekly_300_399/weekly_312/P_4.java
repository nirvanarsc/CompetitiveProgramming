package leetcode.weekly_contests.weekly_300_399.weekly_312;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P_4 {

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        final int n = vals.length;
        Arrays.sort(edges, Comparator.comparingInt(a -> Math.max(vals[a[0]], vals[a[1]])));
        final UnionFind uf = new UnionFind(n);
        int currMax = -1;
        final Map<Integer, Integer> size = new HashMap<>();
        final boolean[] seen = new boolean[n];
        int res = 0;
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            final int curr = Math.max(vals[u], vals[v]);
            if (curr != currMax) {
                currMax = curr;
                size.clear();
            }
            final int ru = uf.find(u);
            final int rv = uf.find(v);
            if (vals[u] == currMax && !seen[u]) {
                size.merge(ru, 1, Integer::sum);
                seen[u] = true;
            }
            if (vals[v] == currMax && !seen[v]) {
                size.merge(rv, 1, Integer::sum);
                seen[v] = true;
            }
            final int su = size.getOrDefault(ru, 0);
            final int sv = size.getOrDefault(rv, 0);
            res += su * sv;
            uf.union(u, v);
            size.merge(ru, sv, Integer::sum);
            size.merge(rv, su, Integer::sum);
        }
        return n + res;
    }
}
