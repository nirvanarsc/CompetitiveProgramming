package leetcode.medium;

public class P_200 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int numIslandsDFS(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfs(row, col, grid);
                }
            }
        }
        return res;
    }

    private static void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '*';
        for (int[] dir : DIRS) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }

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

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    for (int[] dir : DIRS) {
                        final int nx = row + dir[0];
                        final int ny = col + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                            uf.union(getIndex(m, row, col), getIndex(m, nx, ny));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && uf.find(getIndex(m, row, col)) == getIndex(m, row, col)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int getIndex(int colSize, int r, int c) {
        return r * colSize + c;
    }
}
