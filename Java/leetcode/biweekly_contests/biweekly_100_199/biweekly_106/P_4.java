package leetcode.biweekly_contests.biweekly_100_199.biweekly_106;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_4 {

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[] idx = new int[1 << m];
        Arrays.fill(idx, -1);
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = 0; j < m; j++) {
                mask |= grid[i][j] << j;
            }
            idx[mask] = i;
        }
        if (idx[0] != -1) {
            return Collections.singletonList(idx[0]);
        }
        for (int i = 0; i < (1 << m); i++) {
            for (int j = 0; j < (1 << m); j++) {
                if ((i & j) == 0 && idx[i] != -1 && idx[j] != -1) {
                    return Arrays.asList(Math.min(idx[i], idx[j]), Math.max(idx[i], idx[j]));
                }
            }
        }
        return Collections.emptyList();
    }
}
