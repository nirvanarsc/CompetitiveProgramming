package leetcode.weekly_contests.weekly_300_399.weekly_355;

public class P_2 {

    public long maxArrayValue(int[] nums) {
        long sum = 0;
        final int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > sum) {
                sum = 0;
            }
            sum += nums[i];
        }
        return sum;
    }
}
