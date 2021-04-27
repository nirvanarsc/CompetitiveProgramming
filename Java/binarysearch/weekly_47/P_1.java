package binarysearch.weekly_47;

import java.util.Arrays;

public class P_1 {

    public int solve(int[] nums) {
        Arrays.sort(nums);
        int l1 = 1;
        int l2 = nums[nums.length - 1];
        for (int i = 0, j = nums.length - 1; i < 3; i++, j--) {
            l1 *= nums[j];
        }
        for (int i = 0; i < 2; i++) {
            l2 *= nums[i];
        }
        return Math.max(l1, l2);
    }
}
