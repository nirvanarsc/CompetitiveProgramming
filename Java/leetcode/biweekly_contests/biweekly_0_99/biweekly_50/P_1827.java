package leetcode.biweekly_contests.biweekly_0_99.biweekly_50;

public class P_1827 {

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                res += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }
        return res;
    }
}
