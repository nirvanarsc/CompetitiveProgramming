package leetcode.weekly_contests.weekly_0_99.weekly_70;

public class P_778 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

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

    public int swimInWater(int[][] grid) {
        final int n = grid.length;
        int lo = 0;
        int hi = n * n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(grid, mid, n)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[][] g, int mid, int n) {
        final UnionFind uf = new UnionFind(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] <= mid) {
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && g[nx][ny] <= mid) {
                            uf.union(i * n + j, nx * n + ny);
                        }
                    }
                }
            }
        }
        return uf.find(0) == uf.find((n * n) - 1);
    }
}
