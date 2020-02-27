package hard;

import java.util.Collections;
import java.util.TreeSet;

public class P_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            final int[] sums = new int[n];
            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    sums[i] += matrix[i][right];
                }
                final TreeSet<Integer> set = new TreeSet<>(Collections.singleton(0));
                int currSum = 0;
                for (int sum : sums) {
                    currSum += sum;
                    final Integer minimumGap = set.ceiling(currSum - k);
                    if (minimumGap != null) {
                        result = Math.max(result, currSum - minimumGap);
                    }
                    set.add(currSum);
                }
            }
        }

        return result;
    }
}
