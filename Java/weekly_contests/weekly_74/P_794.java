package weekly_contests.weekly_74;

public class P_794 {

    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                x += c == 'X' ? 1 : 0;
                o += c == 'O' ? 1 : 0;
            }
        }
        if (x != o && x != o + 1) {
            return false;
        } else if (x == o) {
            return !playerWins(board, 'X');
        } else {
            return !playerWins(board, 'O');
        }
    }

    public boolean playerWins(String[] board, char player) {
        final int n = board.length;
        final String row = player == 'X' ? "XXX" : "OOO";
        boolean leftDiagonal = true, rightDiagonal = true;
        for (String r : board) {
            if (r.equals(row)) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            boolean match = true;
            for (String r : board) {
                match &= r.charAt(j) == player;
            }
            if (match) {
                return true;
            }
            leftDiagonal &= board[j].charAt(j) == player;
            rightDiagonal &= board[j].charAt(n - j - 1) == player;
        }
        return leftDiagonal || rightDiagonal;
    }
}
