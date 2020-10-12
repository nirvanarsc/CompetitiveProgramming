package leetcode.weekly_contests.weekly_76;

import utils.DataStructures.UnionFind;

public class P_803 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[] hitBricks(int[][] grid, int[][] hits) {
        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    unionAround(grid, uf, i, j);
                }
            }
        }
        int last = uf.size()[uf.find(0)];
        final int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            final int currX = hits[i][0];
            final int currY = hits[i][1];
            if (grid[currX][currY] == 2) {
                grid[currX][currY] = 1;
                unionAround(grid, uf, currX, currY);
                final int nextLast = uf.size()[uf.find(0)];
                res[i] = Math.max(res[i], nextLast - last - 1);
                last = nextLast;
            }
        }
        return res;
    }

    private static void unionAround(int[][] grid, UnionFind uf, int currX, int currY) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int curr = getIndex(m, currX, currY);
        for (int[] dir : DIRS) {
            final int nx = currX + dir[0];
            final int ny = currY + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                uf.union(curr, getIndex(m, nx, ny));
            }
        }
        if (currX == 0) {
            uf.union(0, curr);
        }
    }

    private static int getIndex(int colSize, int x, int y) {
        return x * colSize + y;
    }
}
