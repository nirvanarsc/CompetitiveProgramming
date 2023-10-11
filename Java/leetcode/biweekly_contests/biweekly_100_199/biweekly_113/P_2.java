package leetcode.biweekly_contests.biweekly_100_199.biweekly_113;

import java.util.List;

public class P_2 {

    public int minLengthAfterRemovals(List<Integer> nums) {
        final int n = nums.size();
        int i = 0;
        int j = n - 1;
        while (nums.get(i) < nums.get(j)) {
            i++;
            j--;
        }
        final int ub = upperBound(nums, nums.get(i) - 1);
        final int lo = lowerBound(nums, nums.get(j) + 1);
        final int d = j - i + 1;
        final int replaceable = d / 2;
        return d - 2 * Math.min(replaceable, Math.min(n - lo, ub + 1));
    }

    private static int upperBound(List<Integer> nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            final int mid = (lo + hi + 1) >>> 1;
            if (nums.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums.get(lo) > target ? -1 : lo;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
