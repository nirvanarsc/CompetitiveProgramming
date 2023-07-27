package leetcode.biweekly_contests.biweekly_100_199.biweekly_104;

public class P_3 {

    public long maximumOr(int[] nums, int k) {
        final int n = nums.length;
        final int[] pre = new int[n + 1];
        final int[] suff = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] |= pre[i - 1] | nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            suff[i] |= suff[i + 1] | nums[i];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (long) nums[i] << k | pre[i] | suff[i + 1]);
        }
        return res;
    }
}
