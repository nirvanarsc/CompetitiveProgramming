package leetcode.weekly_contests.weekly_275;

public class P_2 {

    public int minSwaps(int[] nums) {
        final int n = nums.length;
        final int[] d = new int[2 * n];
        int w = 0;
        for (int i = 0; i < 2 * n; i++) {
            d[i] = nums[i % n];
            w += d[i];
        }
        w /= 2;
        final int[] pre = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            pre[i] = pre[i - 1] + d[i - 1];
        }
        int res = 2 * n;
        for (int i = 0; i <= 2 * n - w; i++) {
            res = Math.min(res, w - (pre[i + w] - pre[i]));
        }
        return res;
    }
}
