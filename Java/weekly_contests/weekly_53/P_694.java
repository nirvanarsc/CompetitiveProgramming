package weekly_contests.weekly_53;

import java.util.HashSet;
import java.util.Set;

public class P_694 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numDistinctIslands(int[][] grid) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    set.add(dfs(grid, i, j, new int[] { 1 }));
                }
            }
        }
        return set.size();
    }

    private static int dfs(int[][] grid, int r, int c, int[] k) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            k[0] <<= 1;
            return k[0];
        }
        int res = k[0];
        grid[r][c] = 0;
        for (int[] dir : DIRS) {
            k[0]++;
            res += dfs(grid, r + dir[0], +c + dir[1], k);
        }
        return res;
    }

    public int numDistinctIslandsString(int[][] grid) {
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    final StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] grid, int r, int c, StringBuilder sb) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            sb.append('#');
            return;
        }
        grid[r][c] = 0;
        for (int[] dir : DIRS) {
            sb.append(dir[0] + "," + dir[1]);
            dfs(grid, r + dir[0], +c + dir[1], sb);
        }
    }
}
