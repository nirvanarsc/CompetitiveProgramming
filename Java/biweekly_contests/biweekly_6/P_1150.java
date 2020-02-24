package biweekly_contests.biweekly_6;

public class P_1150 {

    public boolean isMajorityElement(int[] nums, int target) {
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

        final int first = lo;

        hi = nums.length;

        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] < target + 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        final int last = lo;

        return (last - first) >= nums.length / 2;
    }
}
