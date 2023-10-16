package leetcode.weekly_contests.weekly_300_399.weekly_365;

public class P_1 {

    public long maximumTripletValue(int[] nums) {
        final int n = nums.length;
        final int[] pre = new int[n + 1];
        final int[] suff = new int[n + 1];
        for (int i = 1, j = n - 1; i <= n; i++, j--) {
            pre[i] = Math.max(pre[i - 1], nums[i - 1]);
            suff[j] = Math.max(suff[j + 1], nums[j]);
        }
        long res = 0;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (long) (pre[i] - nums[i]) * suff[i + 1]);
        }
        return res;
    }
}
