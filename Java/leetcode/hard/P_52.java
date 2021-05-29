package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_52 {

    static int res;

    public int totalNQueens(int n) {
        res = 0;
        dfs(0, n, new ArrayList<>());
        return res;
    }

    private static void dfs(int row, int n, List<Integer> curr) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, n, curr)) {
                curr.add(1 << col);
                dfs(row + 1, n, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean canPlace(int row, int col, int n, List<Integer> curr) {
        for (int i = row - 1, j = 1; i >= 0; i--, j++) {
            final int L = col - j;
            final int R = col + j;
            if (L >= 0 && (curr.get(i) & (1 << L)) != 0) {
                return false;
            }
            if ((curr.get(i) & (1 << col)) != 0) {
                return false;
            }
            if (R < n && (curr.get(i) & (1 << R)) != 0) {
                return false;
            }
        }
        return true;
    }
}
