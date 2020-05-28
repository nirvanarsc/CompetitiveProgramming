package easy;

public class P_35 {

    public int searchInsert(int[] nums, int target) {
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
}
