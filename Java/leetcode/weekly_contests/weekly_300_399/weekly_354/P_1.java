package leetcode.weekly_contests.weekly_300_399.weekly_354;

public class P_1 {

    public int sumOfSquares(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                res += nums[i] * nums[i];
            }
        }
        return res;
    }
}
