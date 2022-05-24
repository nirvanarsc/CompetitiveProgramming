package leetcode.weekly_contests.weekly_0_99.weekly_82;

import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.UnionFind;

public class P_827 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int largestIsland(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, uf, i * m + j);
                }
            }
        }
        int res = 0;
        final int[] size = uf.size();
        for (int t : size) {
            res = Math.max(res, t);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int curr = 1;
                    final Set<Integer> neighbours = new HashSet<>();
                    for (int[] dir : DIRS) {
                        final int newX = i + dir[0];
                        final int newY = j + dir[1];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 2) {
                            boolean add = true;
                            for (int next : neighbours) {
                                if (uf.find(next) == uf.find(newX * m + newY)) {
                                    add = false;
                                }
                            }
                            if (add) {
                                curr += size[uf.find(newX * m + newY)];
                                neighbours.add(newX * m + newY);
                            }
                        }
                    }
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int r, int c, UnionFind uf, int p) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        uf.union(p, r * grid[0].length + c);
        for (int[] dir : DIRS) {
            dfs(grid, r + dir[0], c + dir[1], uf, p);
        }
    }
}
