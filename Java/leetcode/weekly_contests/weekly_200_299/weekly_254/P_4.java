package leetcode.weekly_contests.weekly_200_299.weekly_254;

@SuppressWarnings("UnnecessaryLocalVariable")
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

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int latestDayToCross(int row, int col, int[][] cells) {
        final int n = row;
        final int m = col;

        final int top = n * m;
        final int bot = n * m + 1;

        final UnionFind uf = new UnionFind(n * m + 2);

        final int[][] g = new int[n][m];

        for (int[] cell : cells) {
            final int u = cell[0] - 1;
            final int v = cell[1] - 1;
            g[u][v] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0) {
                    if (i == 0) {
                        uf.union(top, j);
                    } else if (i == n - 1) {
                        uf.union(bot, i * m + j);
                    }
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 0) {
                            uf.union(i * m + j, nx * m + ny);
                        }
                    }
                }
            }
        }

        if (uf.find(top) == uf.find(bot)) {
            return cells.length;
        }

        for (int i = cells.length - 1; i >= 0; i--) {
            final int u = cells[i][0] - 1;
            final int v = cells[i][1] - 1;
            g[u][v] = 0;

            if (u == 0) {
                uf.union(top, v);
            } else if (u == n - 1) {
                uf.union(bot, u * m + v);
            }

            for (int[] dir : DIRS) {
                final int nx = u + dir[0];
                final int ny = v + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 0) {
                    uf.union(u * m + v, nx * m + ny);
                }
            }

            if (uf.find(top) == uf.find(bot)) {
                return i;
            }
        }

        return -1;
    }
}
