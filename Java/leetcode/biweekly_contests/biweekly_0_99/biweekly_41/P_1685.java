package leetcode.biweekly_contests.biweekly_0_99.biweekly_41;

public class P_1685 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int n = nums.length;
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        final int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            final long ll = (long) (i + 1) * nums[i] - pre[i + 1];
            final long rr = pre[n] - pre[i + 1] - (long) (n - i - 1) * nums[i];
            res[i] = (int) (ll + rr);
        }
        return res;
    }
}
