package easy;

public class P_35 {

    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
