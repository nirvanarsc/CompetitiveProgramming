package leetcode.weekly_contests.weekly_100_199.weekly_123;

public class P_990 {

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

    public boolean equationsPossible(String[] equations) {
        final UnionFind uf = new UnionFind(26);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                final int u = s.charAt(0) - 'a';
                final int v = s.charAt(3) - 'a';
                uf.union(u, v);
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                final int u = s.charAt(0) - 'a';
                final int v = s.charAt(3) - 'a';
                if (uf.find(u) == uf.find(v)) {
                    return false;
                }
            }
        }
        return true;
    }
}
