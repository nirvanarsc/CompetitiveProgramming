package leetcode.weekly_contests.weekly_232;

public class P_1793 {

    public int maximumScore(int[] nums, int k) {
        final int[] left = new int[k + 1];
        final int[] right = new int[nums.length - k];
        System.arraycopy(nums, 0, left, 0, k + 1);
        System.arraycopy(nums, k, right, 0, nums.length - k);
        for (int i = left.length - 2; i >= 0; i--) {
            left[i] = Math.min(left[i], left[i + 1]);
        }
        for (int i = 1; i < right.length; i++) {
            right[i] = Math.min(right[i], right[i - 1]);
        }
        final int[] rev = new int[nums.length - k];
        for (int i = 0, j = right.length - 1; i < right.length; i++, j--) {
            rev[i] = right[j];
        }
        int res = 0;
        for (int i = 0; i < left.length; i++) {
            final int other = lowerBound(rev, left[i]);
            final int L = left.length - i;
            final int R = right.length - other;
            res = Math.max(res, (L + R - 1) * left[i]);
        }
        for (int i = 0; i < rev.length; i++) {
            final int other = lowerBound(left, rev[i]);
            final int L = rev.length - i;
            final int R = left.length - other;
            res = Math.max(res, (L + R - 1) * rev[i]);
        }
        return res;
    }

    private static int lowerBound(int[] l, int t) {
        int lo = 0;
        int hi = l.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (l[mid] < t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
