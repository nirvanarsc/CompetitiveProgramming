package leetcode.weekly_contests.weekly_218;

import java.util.Arrays;

public class P_1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i < j) {
            final int sum = nums[i] + nums[j];
            if (sum == k) {
                res++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
