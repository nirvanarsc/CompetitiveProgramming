package binarysearch.weekly_31;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    private static final int[][] DIRS =
            { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

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

    private static int getIndex(int colSize, int r, int c) {
        return r * colSize + c;
    }

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final UnionFind uf = new UnionFind(n * m + 2);
        final int NE = n * m;
        final int SW = n * m + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == m - 1) {
                        uf.union(getIndex(m, i, j), NE);
                    } else if (i == n - 1 || j == 0) {
                        uf.union(getIndex(m, i, j), SW);
                    }
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] == 1) {
                            uf.union(getIndex(m, i, j), getIndex(m, nx, ny));
                        }
                    }
                }
            }
        }
        if (uf.find(NE) == uf.find(SW)) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    final List<int[]> valid = new ArrayList<>();
                    if (i == 0 || j == m - 1) {
                        // connect zero to NE
                        valid.add(new int[] { n, 0 });
                    } else if (i == n - 1 || j == 0) {
                        // connect zero to SW
                        valid.add(new int[] { n, 1 });
                    }
                    for (int[] dir : DIRS) {
                        final int nx = i + dir[0];
                        final int ny = j + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] == 1) {
                            valid.add(new int[] { nx, ny });
                        }
                    }
                    for (int k = 0; k < valid.size(); k++) {
                        int mask = 0;
                        for (int l = k + 1; l < valid.size(); l++) {
                            if (uf.find(getIndex(m, valid.get(k)[0], valid.get(k)[1])) == uf.find(NE)) {
                                mask |= 1;
                            }
                            if (uf.find(getIndex(m, valid.get(k)[0], valid.get(k)[1])) == uf.find(SW)) {
                                mask |= 2;
                            }
                            if (uf.find(getIndex(m, valid.get(l)[0], valid.get(l)[1])) == uf.find(NE)) {
                                mask |= 1;
                            }
                            if (uf.find(getIndex(m, valid.get(l)[0], valid.get(l)[1])) == uf.find(SW)) {
                                mask |= 2;
                            }
                        }
                        if (mask == 3) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 2;
    }
}
