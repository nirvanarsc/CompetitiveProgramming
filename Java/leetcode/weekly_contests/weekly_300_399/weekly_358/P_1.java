package leetcode.weekly_contests.weekly_300_399.weekly_358;

public class P_1 {

    public int maxSum(int[] nums) {
        final int n = nums.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f(nums[i]) == f(nums[j])) {
                    res = Math.max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }

    private static int f(int n) {
        int res = 0;
        while (n > 0) {
            res = Math.max(res, n % 10);
            n /= 10;
        }
        return res;
    }
}
