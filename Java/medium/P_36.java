package medium;

import java.util.HashSet;
import java.util.Set;

public class P_36 {

    private static final int SMALL = 3;
    private static final int BIG = 9;

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < BIG; i += SMALL) {
            for (int j = 0; j < BIG; j += SMALL) {
                if (!checkCube(board, i, j)) {
                    return false;
                }
            }
        }

        if (!checkRowCol(board, true)) {
            return false;
        }

        return checkRowCol(board, false);
    }

    private static boolean checkRowCol(char[][] board, boolean row) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0; i < BIG; i++) {
            for (int j = 0; j < BIG; j++) {
                if (set.contains(row ? board[i][j] : board[j][i])) {
                    return false;
                }
                if ((row ? board[i][j] : board[j][i]) != '.') {
                    set.add(row ? board[i][j] : board[j][i]);
                }
            }
            set.clear();
        }
        return true;
    }

    private static boolean checkCube(char[][] board, int rowStart, int colStart) {
        final Set<Character> set = new HashSet<>();
        for (int i = rowStart; i < rowStart + SMALL; i++) {
            for (int j = colStart; j < colStart + SMALL; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuStrings(char[][] board) {
        final Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                final char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + '-' + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(
                new char[][] {
                        { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                        { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                        { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                        { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                        { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                        { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                        { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                        { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                        { '.', '.', '4', '.', '.', '.', '.', '.', '.' }

                }
        ));
    }
}
