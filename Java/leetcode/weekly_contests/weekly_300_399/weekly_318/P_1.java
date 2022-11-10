package leetcode.weekly_contests.weekly_300_399.weekly_318;

public class P_1 {

    public int[] applyOperations(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        final int[] res = new int[n];
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                res[idx++] = num;
            }
        }
        return res;
    }
}
