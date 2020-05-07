package weekly_contests.weekly_21;

public class P_529 {

    private static final int[][] NEIGHBOURS = {
            { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        }
        return board;
    }

    private static void dfs(char[][] board, int r, int c) {
        if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] != 'E') {
            return;
        }
        int res = 0;
        for (int[] next : NEIGHBOURS) {
            final int nR = r + next[0];
            final int nC = c + next[1];
            if (nR >= 0 && nR < board.length && nC >= 0 && nC < board[0].length && board[nR][nC] == 'M') {
                res++;
            }
        }
        board[r][c] = res == 0 ? 'B' : Character.forDigit(res, 10);
        if(board[r][c] == 'B') {
            for (int[] dir : NEIGHBOURS) {
                dfs(board, r + dir[0], c + dir[1]);
            }
        }
    }
}
