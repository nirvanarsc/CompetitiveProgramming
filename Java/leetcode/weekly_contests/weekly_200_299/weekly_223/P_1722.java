package leetcode.weekly_contests.weekly_200_299.weekly_223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1722 {

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
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        final int n = source.length;
        final UnionFind uf = new UnionFind(n);
        for (int[] p : allowedSwaps) {
            uf.union(p[0], p[1]);
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int par = uf.find(i);
            g.computeIfAbsent(par, val -> new ArrayList<>()).add(i);
        }
        int res = 0;
        for (List<Integer> cc : g.values()) {
            final Map<Integer, Integer> tt = new HashMap<>();
            for (int idx : cc) {
                tt.merge(target[idx], 1, Integer::sum);
            }
            for (int idx : cc) {
                final int count = tt.getOrDefault(source[idx], 0);
                if (count > 0) {
                    tt.merge(source[idx], -1, Integer::sum);
                }
            }
            for (int val : tt.values()) {
                res += val;
            }
        }
        return res;
    }
}
