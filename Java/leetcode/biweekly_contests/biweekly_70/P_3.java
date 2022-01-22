package leetcode.biweekly_contests.biweekly_70;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P_3 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = (int) 1e9;
            }
        }
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);
        d[start[0]][start[1]] = 0;
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                if (d[curr[0]][curr[1]] < level) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = curr[0] + dir[0];
                    final int ny = curr[1] + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] != 0) {
                        if (d[nx][ny] > level + 1) {
                            d[nx][ny] = level + 1;
                            dq.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        final List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] != (int) 1e9) {
                    if (pricing[0] <= grid[i][j] && grid[i][j] <= pricing[1]) {
                        list.add(new int[] { i, j });
                    }
                }
            }
        }
        list.sort((a, b) -> {
            if (d[a[0]][a[1]] == d[b[0]][b[1]]) {
                if (grid[a[0]][a[1]] == grid[b[0]][b[1]]) {
                    if (a[0] == b[0]) {
                        return Integer.compare(a[1], b[1]);
                    }
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]);
            }
            return Integer.compare(d[a[0]][a[1]], d[b[0]][b[1]]);
        });
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            res.add(Arrays.asList(list.get(i)[0], list.get(i)[1]));
        }
        return res;
    }
}
