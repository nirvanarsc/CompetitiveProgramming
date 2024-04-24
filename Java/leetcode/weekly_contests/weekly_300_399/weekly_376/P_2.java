package leetcode.weekly_contests.weekly_300_399.weekly_376;

import java.util.Arrays;

public class P_2 {

    public static final int[][] EMPTY = new int[0][];

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        final int n = nums.length / 3;
        final int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            if (nums[(3 * i) + 2] - nums[3 * i] > k) {
                return EMPTY;
            }
            res[i] = new int[] { nums[3 * i], nums[(3 * i) + 1], nums[(3 * i) + 2] };
        }
        return res;
    }
}
