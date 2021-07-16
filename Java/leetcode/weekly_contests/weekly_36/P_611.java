package leetcode.weekly_contests.weekly_36;

import java.util.Arrays;

public class P_611 {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int res = 0;
        for (int hi = 2; hi < n; hi++) {
            int l = 0, r = hi - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[hi]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public int triangleNumberUB(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                res += upperBound(nums, j, nums[i] + nums[j] - 1) - j;
            }
        }
        return res;
    }

    private static int upperBound(int[] nums, int from, int target) {
        int lo = from;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
