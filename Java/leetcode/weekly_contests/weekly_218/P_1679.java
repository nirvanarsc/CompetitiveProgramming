package leetcode.weekly_contests.weekly_218;

import java.util.Arrays;

public class P_1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        int res = 0;
        while (lo < hi) {
            final int sum = nums[lo] + nums[hi];
            if (sum == k) {
                lo++;
                hi--;
                res++;
            } else if (sum < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }
}
