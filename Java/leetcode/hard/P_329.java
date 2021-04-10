package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[] inDegree = new int[n * m];
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int u = i * m + j;
                for (int[] dir : DIRS) {
                    final int nx = i + dir[0];
                    final int ny = j + dir[1];
                    final int v = nx * m + ny;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[i][j] < matrix[nx][ny]) {
                        inDegree[v]++;
                        g.get(u).add(v);
                    }
                }
            }
        }
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n * m; i++) {
            if (inDegree[i] == 0) {
                dq.offerLast(i);
            }
        }
        int res = 0;
        while (!dq.isEmpty()) {
            for (int size = dq.size(); size > 0; size--) {
                final int u = dq.removeFirst();
                for (int next : g.get(u)) {
                    if (--inDegree[next] == 0) {
                        dq.offerLast(next);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
