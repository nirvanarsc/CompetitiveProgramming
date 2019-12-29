package biweekly_16;

import java.util.List;

public class P_1301 {

    public int[] pathsWithMaxScore(List<String> board) {
        final int n = board.size();
        final int m = board.get(0).length();
        final Integer[][][] dp = new Integer[n][m][2];
        final Integer[] dfs = dfs(n - 1, m - 1, board, dp);
        if (dfs[0] == Integer.MIN_VALUE) {
            return new int[2];
        }
        return new int[] { dfs[0], dfs[1] };
    }

    public static Integer[] dfs(int row, int col, List<String> board, Integer[][][] dp) {
        if (row == 0 && col == 0) {
            return new Integer[] { 0, 1 };
        }
        if (row < 0 || col < 0 || board.get(row).charAt(col) == 'X') {
            return new Integer[] { Integer.MIN_VALUE, 0 };
        }
        if (dp[row][col][0] != null) {
            return dp[row][col];
        }

        int curr = 0;
        if (board.get(row).charAt(col) != 'S') { curr = board.get(row).charAt(col) - '0'; }
        Integer[] max = { Integer.MIN_VALUE, 0 };
        for (int[] dir : new int[][] { { 0, -1 }, { -1, 0 }, { -1, -1 } }) {
            final Integer[] dfs = dfs(row + dir[0], col + dir[1], board, dp);
            if (dfs[0] != Integer.MIN_VALUE) {
                if (dfs[0] > max[0]) {
                    max = dfs.clone();
                } else if (dfs[0].equals(max[0])) {
                    max[1] = (max[1] + dfs[1]) % ((int) 1e9 + 7);
                }
            }
        }
        if (max[0] != Integer.MIN_VALUE) {
            max[0] += curr;
        }
        return dp[row][col] = max;
    }

    public int[] pathsWithMaxScore2(List<String> board) {
        final int m = board.size();
        final int n = board.get(0).length();
        final int[][][] dp = new int[m][n][2];
        dp[m - 1][n - 1][1] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (dp[r][c][1] == 0) {
                    continue;
                }
                for (int[] dir : new int[][] { { 0, -1 }, { -1, 0 }, { -1, -1 } }) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && board.get(nr).charAt(nc) != 'X') {
                        int nsum = dp[r][c][0];
                        if (board.get(nr).charAt(nc) != 'E') {
                            nsum += board.get(nr).charAt(nc) - '0';
                        }
                        if (nsum > dp[nr][nc][0]) {
                            dp[nr][nc][1] = dp[r][c][1];
                            dp[nr][nc][0] = nsum;
                        } else if (nsum == dp[nr][nc][0]) {
                            dp[nr][nc][1] = (dp[nr][nc][1] + dp[r][c][1]) % ((int) 1e9 + 7);
                        }
                    }
                }
            }
        }
        return new int[] { dp[0][0][0], dp[0][0][1] };
    }
}
