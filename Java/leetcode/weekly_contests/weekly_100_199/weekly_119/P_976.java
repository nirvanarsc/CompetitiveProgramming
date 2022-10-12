package leetcode.weekly_contests.weekly_100_199.weekly_119;

import java.util.Arrays;

public class P_976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
