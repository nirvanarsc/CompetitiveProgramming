package medium;

public class P_34 {

    public int[] searchRange(int[] nums, int target) {
        final int first = bs(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[] { -1, -1 };
        }
        final int last = bs(nums, target + 1) - 1;
        return new int[] { first, last };
    }

    public int bs(int[] nums, int target) {
        int lo = 0, hi = nums.length;
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

    public int[] searchRangeNew(int[] nums, int target) {
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
        if (lo == nums.length || nums[lo] != target) {
            return new int[] { -1, -1 };
        }
        final int first = lo;
        hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return new int[] { first, lo - 1 };
    }
}
