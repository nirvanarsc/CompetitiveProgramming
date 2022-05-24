package leetcode.weekly_contests.weekly_200_299.weekly_267;

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

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        final int q = requests.length;
        final UnionFind uf = new UnionFind(n);
        final boolean[] res = new boolean[q];
        for (int i = 0; i < q; i++) {
            final int u = requests[i][0];
            final int v = requests[i][1];
            final int pu = uf.find(u);
            final int pv = uf.find(v);
            boolean ok = true;
            for (int[] r : restrictions) {
                final int ppu = uf.find(r[0]);
                final int ppv = uf.find(r[1]);
                if ((pu == ppu && pv == ppv) || (pu == ppv && pv == ppu)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                uf.union(u, v);
            }
            res[i] = ok;
        }
        return res;
    }
}
