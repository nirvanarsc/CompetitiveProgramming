package medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class P_348 {

    static class TicTacToe {
        Map<Integer, Integer> row1 = new HashMap<>();
        Map<Integer, Integer> col1 = new HashMap<>();
        Map<Integer, Integer> row2 = new HashMap<>();
        Map<Integer, Integer> col2 = new HashMap<>();
        int diagL1;
        int diagL2;
        int diagR1;
        int diagR2;
        int limit;

        TicTacToe(int n) {
            limit = n;
        }

        public int move(int row, int col, int player) {
            if (player == 1) {
                if (row1.merge(row, 1, Integer::sum) == limit) { return 1; }
                if (col1.merge(col, 1, Integer::sum) == limit) { return 1; }
                if (row == col) {
                    if (++diagL1 == limit) { return 1; }
                }
                if (row + col == limit - 1) {
                    if (++diagR1 == limit) { return 1; }
                }
            } else {
                if (row2.merge(row, 1, Integer::sum) == limit) { return 2; }
                if (col2.merge(col, 1, Integer::sum) == limit) { return 2; }
                if (row == col) {
                    if (++diagL2 == limit) { return 2; }
                }
                if (row + col == limit - 1) {
                    if (++diagR2 == limit) { return 2; }
                }
            }
            return 0;
        }
    }
}
