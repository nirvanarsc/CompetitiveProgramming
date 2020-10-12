package leetcode.medium;

public class P_261 {

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

        public boolean union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return false;
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
            return true;
        }

        public int count() { return count; }
    }

    public boolean validTree(int n, int[][] edges) {
        final UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return false;
            }
        }

        return uf.count == 1;
    }
}
