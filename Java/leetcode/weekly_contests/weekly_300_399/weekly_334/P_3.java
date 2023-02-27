package leetcode.weekly_contests.weekly_300_399.weekly_334;

import java.util.Arrays;

public class P_3 {

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int i = 0;
        for (int j = n / 2; j < n && i < n / 2; j++) {
            i += (2 * nums[i] <= nums[j]) ? 1 : 0;
        }
        return i << 1;
    }
}
