package weekly_contests.weekly_70;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.DataStructures.UnionFind;

public class P_778 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int swimInWater(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int target = getIndex(m, n - 1, m - 1);
        final UnionFind uf = new UnionFind(n * m);
        final PriorityQueue<int[]> g = new PriorityQueue<>(Comparator.comparingInt(a -> a[4]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                populateG(grid, i, j, g);
            }
        }
        int res = Integer.MAX_VALUE;
        while (uf.find(0) != uf.find(target)) {
            final int[] curr = g.remove();
            final int left = getIndex(m, curr[0], curr[1]);
            final int right = getIndex(m, curr[2], curr[3]);
            if (uf.find(left) != uf.find(right)) {
                res = curr[4];
                uf.union(left, right);
            }
        }
        return res;
    }

    private static void populateG(int[][] grid, int x, int y, PriorityQueue<int[]> g) {
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                g.add(new int[] { x, y, nx, ny, Math.max(grid[x][y], grid[nx][ny]) });
            }
        }
    }

    private static int getIndex(int colSize, int x, int y) {
        return x * colSize + y;
    }
}
