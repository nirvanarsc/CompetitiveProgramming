package leetcode.weekly_contests.weekly_200_299.weekly_296;

import java.util.Arrays;

public class P_2 {

    public int partitionArray(int[] nums, int k) {
        int res = 1;
        Arrays.sort(nums);
        int prev = nums[0];
        for (int num : nums) {
            if (num - prev > k) {
                res++;
                prev = num;
            }
        }
        return res;
    }
}
