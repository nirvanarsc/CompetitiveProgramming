package binarysearch.weekly_36;

public class P_1 {

    public int solve(int[] nums, int[] values) {
        int bestDiff = (int) -2e9;
        int res = (int) -2e9;
        for (int i = 0; i < nums.length; i++) {
            bestDiff = Math.max(bestDiff, values[i] - nums[i]);
            res = Math.max(res, values[i] + nums[i] + bestDiff);
        }
        return res;
    }
}
