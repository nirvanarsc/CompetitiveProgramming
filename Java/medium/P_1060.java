package medium;

public class P_1060 {

    public int missingElement(int[] nums, int k) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (countMissing(nums, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[0] + k + lo - 1;
    }

    private static int countMissing(int[] nums, int mid) {
        return nums[mid] - nums[0] - mid;
    }
}
