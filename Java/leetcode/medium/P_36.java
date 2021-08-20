package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class P_36 {

    public boolean isValidSudoku(char[][] board) {
        final Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + ',' + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
