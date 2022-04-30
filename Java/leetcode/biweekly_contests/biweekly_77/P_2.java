package leetcode.biweekly_contests.biweekly_77;

public class P_2 {

    public int minimumAverageDifference(int[] nums) {
        final int n = nums.length;
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long best = (long) 1e15;
        int res = -1;
        for (int i = 0; i < n; i++) {
            final long l = pre[i + 1] / (i + 1);
            final long r = (i == n - 1) ? 0 : ((pre[n] - pre[i + 1]) / (n - i - 1));
            if (best > Math.abs(l - r)) {
                res = i;
                best = Math.abs(l - r);
            }
        }
        return res;
    }
}
