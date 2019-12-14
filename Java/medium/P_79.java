package medium;

public class P_79 {

    public boolean exist(char[][] board, String word) {
        final char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0]) {
                    if (dfs(i, j, 0, w, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int row, int col, int idx, char[] w, char[][] board) {
        if (idx == w.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] == ' ' || board[row][col] != w[idx]) {
            return false;
        }

        final char t = board[row][col];
        board[row][col] = ' ';
        for (int[] dir : new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }) {
            if (dfs(row + dir[0], col + dir[1], idx + 1, w, board)) {
                return true;
            }
        }
        board[row][col] = t;
        return false;
    }
}
