package leetcode.biweekly_contests.biweekly_45;

public class P_1749 {

    public int maxAbsoluteSum(int[] nums) {
        final int[] neg = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            neg[i] = -neg[i];
        }
        return Math.max(maxSubArray(neg), maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int minSum = 0, sum = 0, maxSum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum - minSum);
        }
        return max < 0 ? max : maxSum;
    }
}
