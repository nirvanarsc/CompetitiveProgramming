package leetcode.weekly_contests.weekly_300_399.weekly_392;

import java.util.Arrays;

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

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        final UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        final int[] c = new int[n];
        Arrays.fill(c, -1);
        for (int[] e : edges) {
            final int r = uf.find(e[0]);
            if (c[r] == -1) {
                c[r] = e[2];
            }
            c[r] &= e[2];
        }
        final int q = query.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = uf.find(query[i][0]);
            final int v = uf.find(query[i][1]);
            res[i] = u != v ? -1 : c[u];
        }
        return res;
    }
}
