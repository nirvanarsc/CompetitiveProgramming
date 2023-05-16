package leetcode.weekly_contests.weekly_300_399.weekly_340;

import java.util.Arrays;

public class P_3 {

    public int minimizeMax(int[] nums, int p) {
        final int n = nums.length;
        int lo = 0;
        int hi = (int) 1e9;
        Arrays.sort(nums);
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            int curr = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i + 1] - nums[i] <= mid) {
                    curr++;
                    i++;
                }
            }
            if (curr < p) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
