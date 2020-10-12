package leetcode.weekly_contests.weekly_41;

public class P_643 {

    public double findMaxAverage(int[] nums, int k) {
        double res = -1e18;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - (i >= k ? nums[i - k] : 0);
            if (i >= k - 1) {
                res = Math.max(res, sum / k);
            }
        }
        return res;
    }
}
