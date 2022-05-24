package leetcode.weekly_contests.weekly_0_99.weekly_64;

public class P_747 {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != idx && max < 2 * nums[i]) {
                return -1;
            }
        }
        return idx;
    }
}
