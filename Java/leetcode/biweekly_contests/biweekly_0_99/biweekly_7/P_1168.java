package leetcode.biweekly_contests.biweekly_0_99.biweekly_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_1168 {

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int n) {
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
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final UnionFind uf = new UnionFind(n + 1);
        final List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new int[] { 0, i + 1, wells[i] });
        }
        edges.addAll(Arrays.asList(pipes));
        edges.sort(Comparator.comparingInt(a -> a[2]));
        int res = 0;
        for (int[] e : edges) {
            if (uf.find(e[0]) != uf.find(e[1])) {
                uf.union(e[0], e[1]);
                res += e[2];
            }
        }
        return res;
    }
}
