package leetcode.biweekly_contests.biweekly_100_199.biweekly_104;

import java.util.Arrays;

public class P_2 {

    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int res = 0;
        final int m = nums[0].length;
        for (int i = 0; i < m; i++) {
            int curr = 0;
            for (int[] row : nums) {
                curr = Math.max(curr, row[i]);
            }
            res += curr;
        }
        return res;
    }
}
