package leetcode.weekly_contests.weekly_167;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P_1293 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestPath(int[][] grid, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final Deque<int[]> queue = new LinkedList<>();
        final int[][][] dist = new int[n][m][k + 1];
        for (int[][] g : dist) {
            for (int[] r : g) {
                Arrays.fill(r, Integer.MAX_VALUE);
            }
        }
        dist[0][0][k] = 0;
        queue.offerLast(new int[] { 0, 0, k });
        while (!queue.isEmpty()) {
            final int[] info = queue.removeFirst();
            final int r = info[0];
            final int c = info[1];
            final int leftK = info[2];
            final int curDist = dist[r][c][leftK];
            if (r == n - 1 && c == m - 1) {
                return curDist;
            }
            for (int[] dir : DIRS) {
                final int nextR = dir[0] + r;
                final int nextC = dir[1] + c;
                int nextK = leftK;
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
                    if (grid[nextR][nextC] == 1) {
                        nextK--;
                    }
                    if (nextK >= 0 && curDist + 1 < dist[nextR][nextC][nextK]) {
                        dist[nextR][nextC][nextK] = curDist + 1;
                        queue.offerLast(new int[] { nextR, nextC, nextK });
                    }
                }
            }
        }
        return -1;
    }

    public int shortestPath2(int[][] grid, int k) {
        return dfs(grid, 0, 0, k, new HashMap<>());
    }

    private static int dfs(int[][] grid, int x, int y, int k, Map<String, Integer> cache) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == -1 || k < 0) {
            return -1;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return 0;
        }
        if (cache.containsKey(x + " " + y + ' ' + k)) {return cache.get(x + " " + y + ' ' + k);}
        final int temp = grid[x][y];
        int res = -1;
        grid[x][y] = -1;
        final int t1 = dfs(grid, x - 1, y, k - temp, cache);
        final int t2 = dfs(grid, x + 1, y, k - temp, cache);
        final int t3 = dfs(grid, x, y - 1, k - temp, cache);
        final int t4 = dfs(grid, x, y + 1, k - temp, cache);
        if (t1 != -1) { res = t1 + 1; }
        if (t2 != -1 && (res == -1 || res > t2 + 1)) { res = t2 + 1; }
        if (t3 != -1 && (res == -1 || res > t3 + 1)) { res = t3 + 1; }
        if (t4 != -1 && (res == -1 || res > t4 + 1)) { res = t4 + 1; }
        cache.put(x + " " + y + ' ' + k, res);
        grid[x][y] = temp;
        return res;
    }
}
