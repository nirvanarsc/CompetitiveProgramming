package leetcode.hard;

public class P_154 {

    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (nums[mid] == nums[hi]) {
                hi--;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
