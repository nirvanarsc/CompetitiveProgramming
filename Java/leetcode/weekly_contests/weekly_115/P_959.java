package leetcode.weekly_contests.weekly_115;

import utils.DataStructures.UnionFind;

public class P_959 {

    public int regionsBySlashes(String[] grid) {
        final int n = grid.length;
        final UnionFind uf = new UnionFind(n * n * 4);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int p = f(i, j, n);
                if (i < n - 1) { uf.union(p + 2, f(i + 1, j, n)); }
                if (j < n - 1) { uf.union(p + 1, f(i, j + 1, n) + 3); }
                if (grid[i].charAt(j) == '\\') {
                    uf.union(p, p + 1);
                    uf.union(p + 2, p + 3);
                } else if (grid[i].charAt(j) == '/') {
                    uf.union(p, p + 3);
                    uf.union(p + 1, p + 2);
                } else {
                    uf.union(p, p + 1);
                    uf.union(p, p + 2);
                    uf.union(p, p + 3);
                }
            }
        }

        return uf.count();
    }

    private static int f(int i, int j, int n) {
        return (i * n + j) * 4;
    }
}
