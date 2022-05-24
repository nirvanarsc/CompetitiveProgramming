package leetcode.weekly_contests.weekly_200_299.weekly_200;

import java.util.ArrayList;
import java.util.List;

public class P_1536 {

    public int minSwaps(int[][] grid) {
        final int n = grid.length;
        final List<Integer> rows = new ArrayList<>();
        for (int[] row : grid) {
            int trailingZeroes = 0;
            for (int j = n - 1; j >= 0 && row[j] == 0; j--) {
                trailingZeroes++;
            }
            rows.add(trailingZeroes);
        }
        return dfs(rows, 0, n - 1);
    }

    private static int dfs(List<Integer> row, int idx, int requiredZeroes) {
        if (idx == row.size()) {
            return 0;
        }
        int satisfiedRowIdx = idx;
        int res = 0;
        while (satisfiedRowIdx < row.size() && row.get(satisfiedRowIdx) < requiredZeroes) {
            satisfiedRowIdx++;
        }
        if (satisfiedRowIdx == row.size()) {
            return -1;
        }
        row.add(idx, row.remove(satisfiedRowIdx));
        res += satisfiedRowIdx - idx;
        final int next = dfs(row, idx + 1, requiredZeroes - 1);
        if (next == -1) {
            return -1;
        }
        return res + next;
    }
}
