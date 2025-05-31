package leetcode.weekly_contests.weekly_400_499.weekly_442;

public class P_2 {

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

    public int numberOfComponents(int[][] properties, int k) {
        final int n = properties.length;
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f(properties[i], properties[j]) >= k) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private static int f(int[] l, int[] r) {
        final boolean[] ll = new boolean[105];
        final boolean[] rr = new boolean[105];
        for (int num : l) {
            ll[num] = true;
        }
        int res = 0;
        for (int num : r) {
            if (!rr[num] && ll[num]) {
                res++;
            }
            rr[num] = true;
        }
        return res;
    }
}
