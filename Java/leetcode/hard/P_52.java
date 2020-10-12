package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_52 {

    public int totalNQueens(int n) {
        final int[] res = { 0 };
        recurse(0, n, res, new ArrayList<>());
        return res[0];
    }

    private static void recurse(int row, int n, int[] res, List<Integer> currSolution) {
        if (row == n) {
            res[0]++;
        }
        for (int i = 0; i < n; i++) {
            currSolution.add(i);
            if (isValid(row, currSolution)) {
                recurse(row + 1, n, res, currSolution);
            }
            currSolution.remove(currSolution.size() - 1);
        }
    }

    private static boolean isValid(int row, List<Integer> placement) {
        for (int i = 0; i < row; i++) {
            final int diff = Math.abs(placement.get(i) - placement.get(row));
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
}
