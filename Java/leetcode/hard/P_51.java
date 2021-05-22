package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_51 {

    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> res = new ArrayList<>();
        dfs(0, n, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int row, int n, List<Integer> curr, List<List<String>> res) {
        if (row == n) {
            final List<String> solution = new ArrayList<>();
            for (int mask : curr) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append((mask & (1 << i)) != 0 ? 'Q' : '.');
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, n, curr)) {
                curr.add(1 << col);
                dfs(row + 1, n, curr, res);
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
