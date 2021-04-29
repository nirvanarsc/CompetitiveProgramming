package leetcode.medium;

import java.util.Arrays;

public final class P_33 {

    public int search(int[] nums, int target) {
        final int min = lowerBound(nums, nums[nums.length - 1]);
        final int bs1 = Arrays.binarySearch(nums, 0, min, target);
        final int bs2 = Arrays.binarySearch(nums, min, nums.length, target);
        return bs1 >= 0 ? bs1 : bs2 >= 0 ? bs2 : -1;
    }

    private static int lowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] > target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
