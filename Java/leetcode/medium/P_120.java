package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class P_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        final int[] lastRow = new int[triangle.size() + 1];
        Arrays.fill(lastRow, Integer.MAX_VALUE);
        lastRow[1] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            final int[] temp = new int[i + 1];
            for (int k = 0; k < i + 1; k++) {
                temp[k] = triangle.get(i).get(k) + Math.min(lastRow[k], lastRow[k + 1]);
            }
            System.arraycopy(temp, 0, lastRow, 1, temp.length);
        }
        int res = Integer.MAX_VALUE;
        for (int i : lastRow) {
            res = Math.min(res, i);
        }
        return res;
    }

    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        final int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            final List<Integer> level = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = level.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
