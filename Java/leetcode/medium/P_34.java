package leetcode.medium;

public class P_34 {

    public int[] searchRange(int[] nums, int target) {
        final int first = lowerBound(nums, target);
        final int last = upperBound(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { first, last };
    }

    private static int lowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int upperBound(int[] nums, int target) {
        int lo = 0;
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
