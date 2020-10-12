package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_329 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    // time = O(N*M*lg(N*M)), space = O(N*M)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        final int n = matrix.length;
        final int m = matrix[0].length;
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                q.offer(new int[] { i, j, matrix[i][j] });
            }
        }
        final int[][] dp = new int[n][m];
        while (!q.isEmpty()) {
            final int[] curr = q.remove();
            final int x = curr[0];
            final int y = curr[1];
            dp[x][y] = 1;
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && curr[2] < matrix[nx][ny]) {
                    dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
                }
            }
            res = Math.max(res, dp[x][y]);
        }
        return res;
    }

    public int longestIncreasingPathDFS(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final Integer[][] dp = new Integer[n][m];
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, Integer[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        int max = 1;
        for (int[] dir : DIRS) {
            final int nx = i + dir[0];
            final int ny = j + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[i][j] < matrix[nx][ny]) {
                max = Math.max(max, 1 + dfs(matrix, nx, ny, dp));
            }
        }
        return dp[i][j] = max;
    }

    public int longestIncreasingPathTopSort(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] outdegree = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : DIRS) {
                    final int nx = i + d[0];
                    final int ny = j + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[i][j] < matrix[nx][ny]) {
                        outdegree[i][j]++;
                    }
                }
            }
        }
        final Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (outdegree[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int res;
        for (res = 0; !q.isEmpty(); res++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] node = q.removeFirst();
                for (int[] dir : DIRS) {
                    final int nx = node[0] + dir[0];
                    final int ny = node[1] + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[node[0]][node[1]] > matrix[nx][ny]) {
                        if (--outdegree[nx][ny] == 0) {
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return res;
    }
}
