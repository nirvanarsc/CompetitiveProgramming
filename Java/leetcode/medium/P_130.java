package leetcode.medium;

public final class P_130 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int n;
    static int m;
    static char[][] g;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        g = board;
        fillBorders(board, 'O', '*');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        fillBorders(board, '*', 'O');
    }

    private static void fillBorders(char[][] board, char prev, char next) {
        for (int i = 0; i < n; i++) {
            if (board[i][0] == prev) { dfs(i, 0, prev, next); }
            if (board[i][m - 1] == prev) { dfs(i, m - 1, prev, next); }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == prev) { dfs(0, j, prev, next); }
            if (board[n - 1][j] == prev) { dfs(n - 1, j, prev, next); }
        }
    }

    private static void dfs(int x, int y, char prev, char next) {
        g[x][y] = next;
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == prev) {
                dfs(nx, ny, prev, next);
            }
        }
    }
}
