package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1222 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final List<List<Integer>> res = new ArrayList<>();
        final int[][] board = new int[8][8];
        final int[][] dirs =
                { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }

        for (int[] dir : dirs) {
            recurse(board, king[0], king[1], res, dir);
        }

        return res;
    }

    private static void recurse(int[][] board, int n, int m, List<List<Integer>> res, int[] dir) {
        if (n < 0 || m < 0 || n >= board.length || m >= board[0].length) {
            return;
        }

        if (board[n][m] == 1) {
            res.add(Arrays.asList(n, m));
            return;
        }

        recurse(board, n + dir[0], m + dir[1], res, dir);
    }
}
