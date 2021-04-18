package leetcode.weekly_contests.weekly_139;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        final int n = matrix.length;
        final int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            final int[] pre = new int[m];
            for (int j = i; j < n; j++) {
                final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 1));
                int curr = 0;
                for (int k = 0; k < m; k++) {
                    pre[k] += matrix[j][k];
                    curr += pre[k];
                    res += map.getOrDefault(curr - target, 0);
                    map.merge(curr, 1, Integer::sum);
                }
            }
        }
        return res;
    }
}
