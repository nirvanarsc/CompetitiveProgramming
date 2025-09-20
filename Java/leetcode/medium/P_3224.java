package leetcode.medium;

import java.util.Arrays;

public class P_3224 {

    public int minChanges(int[] nums, int k) {
        final int n = nums.length;
        final int[] f = new int[k + 1];
        final int[] diffs = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            final int a = nums[i];
            final int b = nums[n - i - 1];
            f[Math.abs(a - b)]++;
            diffs[i] = Math.max(Math.max(a, b), k - Math.min(a, b));
        }
        Arrays.sort(diffs);
        int res = (int) 1e9;
        for (int i = 0; i <= k; i++) {
            final int req1 = (n / 2) - f[i];
            final int req2 = lowerBound(diffs, i);
            res = Math.min(res, req1 + req2);
        }
        return res;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
