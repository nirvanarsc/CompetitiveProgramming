package weekly_contests.weekly_105;

public class P_918 {

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
