package leetcode.biweekly_contests.biweekly_0_99.biweekly_58;

public class P_2 {

    private static final int[][] DIRS =
            { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, -1 }, { 1, 1 } };

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int d = 2; d <= 8; d++) {
            if (ok(board, rMove, cMove, color, d)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ok(char[][] board, int rMove, int cMove, char color, int d) {
        final char op = color == 'W' ? 'B' : 'W';
        for (int[] dir : DIRS) {
            final int eX = rMove + dir[0] * d;
            final int eY = cMove + dir[1] * d;
            if (0 <= eX && eX < 8 && 0 <= eY && eY < 8 && board[eX][eY] == color) {
                boolean ok = true;
                for (int z = d - 1; z >= 1; z--) {
                    final int x = rMove + dir[0] * z;
                    final int y = cMove + dir[1] * z;
                    if (0 <= x && x < 8 && 0 <= y && y < 8) {
                        if (board[x][y] != op) {
                            ok = false;
                            break;
                        }
                    } else {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
            }
        }
        return false;
    }
}
