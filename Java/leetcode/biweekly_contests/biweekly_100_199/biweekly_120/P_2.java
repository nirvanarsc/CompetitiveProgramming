package leetcode.biweekly_contests.biweekly_100_199.biweekly_120;

import java.util.Arrays;

public class P_2 {

    public long largestPerimeter(int[] nums) {
        long s = 0;
        for (int num : nums) {
            s += num;
        }
        final int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 1; i--) {
            s -= nums[i];
            if (nums[i] < s) {
                return s + nums[i];
            }
        }
        return -1;
    }
}
