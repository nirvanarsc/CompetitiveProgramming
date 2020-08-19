package medium;

public class P_34 {

    public int[] searchRange(int[] nums, int target) {
        final int lower = lowerBound(nums, target);
        final int upper = upperBound(nums, target);
        if (lower == nums.length || nums[lower] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { lower, upper };
    }

    private static int lowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
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
            final int mid = (lo + hi + 1) >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
