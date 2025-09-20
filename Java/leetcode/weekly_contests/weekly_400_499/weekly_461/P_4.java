package leetcode.weekly_contests.weekly_400_499.weekly_461;

import java.util.Arrays;

public class P_4 {

    public long maxSumTrionic(int[] nums) {
        final int n = nums.length;
        final long INF = (long) -1e18;
        final long[] pfx = new long[n];
        final long[] sfx = new long[n];
        Arrays.fill(pfx, INF);
        Arrays.fill(sfx, INF);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                pfx[i] = nums[i] + Math.max(nums[i - 1], pfx[i - 1]);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                sfx[i] = nums[i] + Math.max(nums[i + 1], sfx[i + 1]);
            }
        }
        long res = INF;
        for (int i = 0; i < n; i++) {
            final int l = i;
            long sum = nums[i];
            while (i + 1 < n && nums[i + 1] <= nums[i]) {
                sum += nums[i + 1];
                i++;
            }
            final int r = i;
            if (l == r) {
                continue;
            }
            boolean ok = true;
            for (int j = l + 1; j <= r; j++) {
                if (nums[j] >= nums[j - 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (l > 0 && r < n - 1) {
                    if (pfx[l] > INF && sfx[r] > INF) {
                        res = Math.max(res, sum + pfx[l] + sfx[r] - nums[l] - nums[r]);
                    }
                }
            }
        }
        return res;
    }
}
