package leetcode.biweekly_contests.biweekly_61;

public class P_1 {

    public int countKDifference(int[] nums, int k) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
