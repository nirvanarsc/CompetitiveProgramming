package leetcode.weekly_contests.weekly_51;

@SuppressWarnings({ "NullThrown", "ConstantConditions" })
public class P_684 {

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

    public int[] findRedundantConnection(int[][] edges) {
        final int n = edges.length;
        final UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            final int u = e[0] - 1;
            final int v = e[1] - 1;
            if (uf.find(u) == uf.find(v)) {
                return e;
            }
            uf.union(u, v);
        }
        throw null;
    }
}
