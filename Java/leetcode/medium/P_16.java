package leetcode.medium;

import java.util.Arrays;

public class P_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        final int n = nums.length;
        int res = -1;
        int minDiff = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                final int curr = nums[i] + nums[lo] + nums[hi];
                if (minDiff > Math.abs(target - curr)) {
                    minDiff = Math.abs(target - curr);
                    res = curr;
                }
                if (curr < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
}
