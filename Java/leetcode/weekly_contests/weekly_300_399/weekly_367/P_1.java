package leetcode.weekly_contests.weekly_300_399.weekly_367;

public class P_1 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int u = Math.abs(i - j);
                final int v = Math.abs(nums[i] - nums[j]);
                if (u >= indexDifference && v >= valueDifference) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
