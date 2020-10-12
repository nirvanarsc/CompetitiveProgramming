package leetcode.medium;

public class P_540 {

    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + end >>> 1;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }
        return nums[start];
    }
}
