package leetcode.medium;

public class P_79 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static int n;
    static int m;
    static char[] w;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        w = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int index) {
        if (index == w.length) {
            return true;
        }
        if (i < 0 || i == n || j < 0 || j == m || board[i][j] != w[index]) {
            return false;
        }
        final char t = board[i][j];
        board[i][j] = '#';
        for (int[] dir : DIRS) {
            if (dfs(board, i + dir[0], j + dir[1], index + 1)) {
                return true;
            }
        }
        board[i][j] = t;
        return false;
    }
}
