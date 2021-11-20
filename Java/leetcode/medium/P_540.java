package leetcode.medium;

public class P_540 {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length / 2;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[2 * mid] == nums[2 * mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[2 * lo];
    }
}
