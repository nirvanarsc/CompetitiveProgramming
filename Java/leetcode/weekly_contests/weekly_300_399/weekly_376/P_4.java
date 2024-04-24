package leetcode.weekly_contests.weekly_300_399.weekly_376;

import java.util.Arrays;

public class P_4 {

    public int maxFrequencyScore(int[] nums, long k) {
        final int n = nums.length;
        Arrays.sort(nums);
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(nums, k, mid)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] nums, long k, int len) {
        final int n = nums.length;
        long ll = 0;
        long rr = 0;
        for (int i = 0; i < (len + 1) / 2; i++) {
            ll += nums[i];
        }
        for (int i = (len + 1) / 2; i < len; i++) {
            rr += nums[i];
        }
        if (check(nums[(len - 1) / 2], k, len, ll, rr)) { return true; }
        for (int i = len, j = 0; i < n; i++, j++) {
            ll -= nums[i - len];
            ll += nums[j + (len + 1) / 2];
            rr -= nums[j + (len + 1) / 2];
            rr += nums[j + len];
            if (check(nums[j + 1 + (len - 1) / 2], k, len, ll, rr)) { return true; }
        }
        return false;
    }

    private static boolean check(long median, long k, int len, long ll, long rr) {
        return median * ((len + 1) / 2) - ll + (rr - median * (len - (len + 1) / 2)) <= k;
    }
}
