package leetcode.weekly_contests.weekly_0_99.weekly_53;

public class P_695 {

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

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    final int u = i * m + j;
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
                            final int v = nx * m + ny;
                            uf.union(u, v);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n * m; i++) {
            if (grid[i / m][i % m] == 1) {
                res = Math.max(res, uf.size[i]);
            }
        }
        return res;
    }
}
