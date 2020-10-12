package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_51 {

    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> res = new ArrayList<>();
        final char[] chars = new char[n];
        Arrays.fill(chars, '.');
        dfs(res, new ArrayList<>(), chars, 0, n);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> list, char[] curr, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(list));
        }
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, list)) {
                curr[col] = 'Q';
                list.add(new String(curr));
                curr[col] = '.';
                dfs(res, list, curr, row + 1, n);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean canPlace(int row, int col, List<String> res) {
        for (int r = row - 1, diff = 1; r >= 0; r--, diff++) {
            final String line = res.get(r);
            if (line.charAt(col) == 'Q') {
                return false;
            }
            if (col - diff >= 0 && line.charAt(col - diff) == 'Q') {
                return false;
            }
            if (col + diff < line.length() && line.charAt(col + diff) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
