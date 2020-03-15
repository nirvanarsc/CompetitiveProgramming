package weekly_contests.weekly_180;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_1380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        final Set<Integer> minRows = new HashSet<>();
        final Set<Integer> maxCols = new HashSet<>();
        for (int[] row : matrix) {
            int min = Integer.MAX_VALUE;
            for (int num : row) {
                min = Math.min(min, num);
            }
            minRows.add(min);
        }
        for (int col = 0; col < matrix[0].length; col++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[col]);
            }
            maxCols.add(max);
        }
        minRows.retainAll(maxCols);
        return new ArrayList<>(minRows);
    }
}
