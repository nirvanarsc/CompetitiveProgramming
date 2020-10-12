package leetcode.easy;

public class P_704 {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int searchUpperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public int searchLowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
