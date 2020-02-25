package weekly_contests.weekly_139;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        final int n = matrix.length;
        final int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                final Map<Integer, Integer> counter = new HashMap<>(Collections.singletonMap(0, 1));
                int curr = 0;
                for (int[] ints : matrix) {
                    curr += ints[j] - (i > 0 ? ints[i - 1] : 0);
                    res += counter.getOrDefault(curr - target, 0);
                    counter.merge(curr, 1, Integer::sum);
                }
            }
        }
        return res;
    }
}
