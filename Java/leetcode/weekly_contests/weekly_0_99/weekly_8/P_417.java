package leetcode.weekly_contests.weekly_0_99.weekly_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_417 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final boolean[][] a = new boolean[n][m];
        final boolean[][] b = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(a, matrix, n, m, i, 0);
            dfs(b, matrix, n, m, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(a, matrix, n, m, 0, i);
            dfs(b, matrix, n, m, n - 1, i);
        }
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] && b[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private static void dfs(boolean[][] seen, int[][] g, int n, int m, int r, int c) {
        if (seen[r][c]) {
            return;
        }
        seen[r][c] = true;
        for (int[] dir : DIRS) {
            final int nr = r + dir[0];
            final int nc = c + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && g[r][c] <= g[nr][nc]) {
                dfs(seen, g, n, m, nr, nc);
            }
        }
    }
}
