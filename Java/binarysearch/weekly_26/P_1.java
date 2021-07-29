package binarysearch.weekly_26;

import java.util.Arrays;

public class P_1 {

    public int solve(int[] nums) {
        final int n = nums.length;
        int lo = 0;
        int hi = n;
        Arrays.sort(nums);
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(nums, mid, n)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return n - lo;
    }

    private static boolean f(int[] nums, int idx, int n) {
        int points = n;
        final int best = nums[idx] + points--;
        for (int i = 0; i < n; i++) {
            if (i != idx && nums[i] + points-- > best) {
                return false;
            }
        }
        return true;
    }
}
