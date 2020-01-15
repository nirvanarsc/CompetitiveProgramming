package easy;

public class P_303 {

    class NumArray {
        int[] dp;

        NumArray(int[] nums) {
            if (nums.length > 0) {
                dp = new int[nums.length];
                dp[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    dp[i] = nums[i] + dp[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return dp[j];
            } else {
                return dp[j] - dp[i - 1];
            }
        }
    }
}
