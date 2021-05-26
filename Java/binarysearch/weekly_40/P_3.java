package binarysearch.weekly_40;

public class P_3 {

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

    public int solve(int[] votes) {
        final int n = votes.length;
        final UnionFind uf = new UnionFind(n + 3);
        for (int i = 0; i < n; i++) {
            final int u = votes[i];
            if (u < 0) {
                uf.union(i, n + 1);
            } else if (u >= n) {
                uf.union(i, n + 2);
            } else {
                final int v = votes[u];
                if (v < 0) {
                    uf.union(i, n + 1);
                } else if (v >= n) {
                    uf.union(i, n + 2);
                } else {
                    uf.union(i, v);
                }
            }
        }
        return uf.size[uf.find(n + 1)] - 1;
    }
}
