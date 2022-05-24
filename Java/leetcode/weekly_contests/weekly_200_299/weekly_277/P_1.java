package leetcode.weekly_contests.weekly_200_299.weekly_277;

import java.util.Arrays;

public class P_1 {

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < n && nums[l] == nums[0]) {
            l++;
        }
        while (r >= 0 && nums[r] == nums[n - 1]) {
            r--;
        }
        return Math.max(0, r - l + 1);
    }
}
