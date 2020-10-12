package leetcode.medium;

public final class P_419 {

    public static int countBattleships(char[][] board) {
        if (board.length == 0) {
            return 0;
        }
        final int m = board.length;
        final int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'
                    && (i == 0 || board[i - 1][j] != 'X')
                    && (j == 0 || board[i][j - 1] != 'X')) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][] {
                { 'X', '.', 'X', '.' },
                { '.', 'X', '.', 'X' },
                { '.', 'X', '.', 'X' },
                { 'X', '.', 'X', '.' },
                }));
    }

    private P_419() {}
}
