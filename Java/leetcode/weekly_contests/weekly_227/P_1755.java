package leetcode.weekly_contests.weekly_227;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_1755 {

    public int minAbsDifference(int[] nums, int goal) {
        final int n = nums.length;
        final int[] half1 = new int[n / 2];
        final int[] half2 = new int[n / 2 + n % 2];
        int idx = 0;
        for (int i = 0; i < half1.length; i++) {
            half1[i] = nums[idx++];
        }
        for (int i = 0; i < half2.length; i++) {
            half2[i] = nums[idx++];
        }
        final List<Long> sum1 = new ArrayList<>();
        final List<Long> sum2 = new ArrayList<>();
        final int l1 = half1.length;
        final int l2 = half2.length;
        long res = (int) 1e18;
        for (int mask = 0; mask < (1 << l2); mask++) {
            long curr = 0;
            for (int i = 0; i < l2; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += half2[i];
                }
            }
            sum2.add(curr);
        }
        for (int mask = 0; mask < (1 << l1); mask++) {
            long curr = 0;
            for (int i = 0; i < l1; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += half1[i];
                }
            }
            sum1.add(curr);
        }
        sum2.sort(Comparator.naturalOrder());
        for (long s1 : sum1) {
            final int ub = upperBound(sum2, goal - s1);
            res = Math.min(res, Math.abs(goal - (s1 + sum2.get(ub))));
            if (ub != sum2.size() - 1) {
                res = Math.min(res, Math.abs(goal - (s1 + sum2.get(ub + 1))));
            }
        }
        return (int) res;
    }

    private static int upperBound(List<Long> nums, long target) {
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
        return lo;
    }
}
