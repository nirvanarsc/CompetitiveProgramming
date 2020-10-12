package leetcode.medium;

public class P_376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return Math.max(wiggle(nums, true), wiggle(nums, false));
    }

    private static int wiggle(int[] nums, boolean inc) {
        int len = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (inc) {
                if (nums[i] > prev) {
                    inc = false;
                    len++;
                }
            } else {
                if (nums[i] < prev) {
                    inc = true;
                    len++;
                }
            }
            prev = nums[i];
        }
        return len;
    }
}
