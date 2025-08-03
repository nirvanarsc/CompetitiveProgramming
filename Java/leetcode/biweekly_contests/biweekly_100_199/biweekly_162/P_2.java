package leetcode.biweekly_contests.biweekly_100_199.biweekly_162;

import java.util.Arrays;

public class P_2 {

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int res = (int) 1e9;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            final int u = lowerBound(nums, (long) k * nums[i]);
            res = Math.min(res, n - u + i);
        }
        for (int i = n - 1; i >= 0; i--) {
            final int u = lowerBound(nums, (long) (nums[i] + k - 1) / k);
            res = Math.min(res, n - 1 - i + u);
        }
        return res;
    }

    private static int lowerBound(int[] arr, long target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
