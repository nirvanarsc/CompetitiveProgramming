package leetcode.weekly_contests.weekly_100_199.weekly_105;

public class P_918 {

    public int maxSubarraySumCircular(int[] nums) {
        int max, currMax, min, currMin, sum;
        max = currMax = (int) -1e9;
        min = currMin = (int) 1e9;
        sum = 0;
        for (int value : nums) {
            currMax = Math.max(currMax + value, value);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + value, value);
            min = Math.min(min, currMin);
            sum += value;
        }
        return max < 0 ? max : Math.max(sum - min, max);
    }
}
