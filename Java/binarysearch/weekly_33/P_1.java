package binarysearch.weekly_33;

import java.util.Arrays;

public class P_1 {

    public int solve(int[] nums, int[] multipliers) {
        if (nums.length < multipliers.length) {
            final int[] temp = nums;
            nums = multipliers;
            multipliers = temp;
        }
        Arrays.sort(nums);
        Arrays.sort(multipliers);
        int res = 0;
        int start = 0;
        int end = nums.length - 1;
        for (int multiplier : multipliers) {
            if (multiplier < 0) {
                res += nums[start++] * multiplier;
            } else {
                break;
            }
        }
        for (int i = multipliers.length - 1; i >= 0; i--) {
            if (multipliers[i] > 0) {
                res += nums[end--] * multipliers[i];
            } else {
                break;
            }
        }
        return res;
    }
}
