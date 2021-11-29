package leetcode.weekly_contests.weekly_269;

import java.util.Arrays;

public class P_2 {

    public int[] getAverages(int[] nums, int k) {
        final int n = nums.length;
        final int[] res = new int[n];
        Arrays.fill(res, -1);
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for (int i = k; i < n - k; i++) {
            res[i] = (int) ((pre[i + k + 1] - pre[i - k]) / (2 * k + 1));
        }
        return res;
    }
}
