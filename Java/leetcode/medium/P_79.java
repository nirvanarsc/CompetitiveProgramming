package leetcode.medium;

public class P_79 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static int n;
    static int m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == n || j < 0 || j == m || board[i][j] != word.charAt(index)) {
            return false;
        }
        final char t = board[i][j];
        board[i][j] = '#';
        for (int[] dir : DIRS) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                return true;
            }
        }
        board[i][j] = t;
        return false;
    }
}
