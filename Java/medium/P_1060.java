package medium;

public class P_1060 {

    public int missingElement(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        final int missingNum = nums[hi] - nums[0] - hi;

        if (missingNum < k) {
            return nums[hi] + k - missingNum;
        }

        while (lo < hi - 1) {
            final int mid = lo + hi >>> 1;
            final int missing = nums[mid] - nums[lo] - (mid - lo);
            if (missing >= k) {
                hi = mid;
            } else {
                lo = mid;
                k -= missing;
            }
        }
        return nums[lo] + k;
    }
}
