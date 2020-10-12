package leetcode.weekly_contests.weekly_56;

import java.util.Arrays;

public class P_719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = (int) 1e9;
        while (lo < hi) {
            final int mid = hi + lo >>> 1;
            int count = 0;
            for (int right = 0, left = 0; right < nums.length; right++) {
                while (left < right && nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
