package weekly_contests.weekly_139;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        final Map<Integer, Integer> map = new HashMap<>();
        int equal = 0;
        for (int[] row : matrix) {
            if (isEqual(row)) {
                equal++;
            } else {
                map.merge(Arrays.hashCode(row), 1, Integer::sum);
            }
        }
        int complements = 0;
        for (int[] row : matrix) {
            complements = Math.max(complements, map.getOrDefault(Arrays.hashCode(row), 0) +
                                                map.getOrDefault(Arrays.hashCode(getComplement(row)), 0));
        }
        return Math.max(complements, equal);
    }

    private static boolean isEqual(int[] row) {
        int sum = 0;
        for (int n : row) {
            sum += n;
        }
        return sum == 0 || sum == row.length;
    }

    private static int[] getComplement(int[] row) {
        final int[] ints = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            ints[i] = row[i] == 1 ? 0 : 1;
        }
        return ints;
    }
}
