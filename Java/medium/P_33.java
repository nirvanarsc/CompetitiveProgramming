package medium;

import java.util.Arrays;

public final class P_33 {

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] > target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] != target) {
            return new int[] { -1, -1 };
        }
        int first = lo;
        hi = nums.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] >= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return new int[] { first, lo };
    }

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        hi = nums.length + lo - 1;
        while (lo <= hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid % nums.length] < target) {
                lo = mid + 1;
            } else if (nums[mid % nums.length] == target) {
                return mid % nums.length;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int searchNew(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        final int bs1 = Arrays.binarySearch(nums, 0, lo, target);
        final int bs2 = Arrays.binarySearch(nums, lo, nums.length, target);
        return bs1 >= 0 ? bs1 : bs2 >= 0 ? bs2 : -1;
    }
}
