package leetcode.weekly_contests.weekly_204;

public class P_1568 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

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

    public int numIslands(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    for (int[] dir : DIRS) {
                        final int nx = row + dir[0];
                        final int ny = col + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                            uf.union(getIndex(m, row, col), getIndex(m, nx, ny));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1 && uf.find(getIndex(m, row, col)) == getIndex(m, row, col)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int getIndex(int colSize, int r, int c) {
        return r * colSize + c;
    }

    public int minDays(int[][] grid) {
        if (numIslands(grid) > 1) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (numIslands(grid) > 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}
