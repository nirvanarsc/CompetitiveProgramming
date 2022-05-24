package leetcode.weekly_contests.weekly_100_199.weekly_152;

public class P_1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        final int[] prefixSum = new int[calories.length];
        for (int i = 0; i < calories.length; i++) {
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + calories[i];
        }
        int res = 0;
        for (int i = 0; i < calories.length - k + 1; i++) {
            final int curr = prefixSum[i + k - 1] - (i > 0 ? prefixSum[i - 1] : 0);
            if (curr > upper) {
                res++;
            } else if (curr < lower) {
                res--;
            }
        }
        return res;
    }
}
