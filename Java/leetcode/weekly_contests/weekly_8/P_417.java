package leetcode.weekly_contests.weekly_8;

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
        final List<List<Integer>> res = new ArrayList<>();
        final int n = matrix.length;
        final int m = matrix[0].length;
        final boolean[][] pacific = new boolean[n][m];
        final boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
            || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        for (int[] d : DIRS) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}
