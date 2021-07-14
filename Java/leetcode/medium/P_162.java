package leetcode.medium;

public class P_162 {

    public int findPeakElementLB(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
