package leetcode.biweekly_contests.biweekly_71;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public long minimumDifference(int[] nums) {
        final int n = nums.length / 3;
        final PriorityQueue<Integer> l = new PriorityQueue<>(Comparator.reverseOrder());
        final PriorityQueue<Integer> r = new PriorityQueue<>();
        long sumL = 0;
        long sumR = 0;
        for (int i = 0; i < n; i++) {
            sumL += nums[i];
            l.add(nums[i]);
        }
        for (int i = 2 * n; i < 3 * n; i++) {
            sumR += nums[i];
            r.add(nums[i]);
        }
        final long[] diff = new long[n + 1];
        for (int i = n; i <= 2 * n; i++) {
            diff[i - n] = sumL;
            if (l.element() > nums[i]) {
                sumL += nums[i] - l.remove();
                l.add(nums[i]);
            }
        }
        for (int i = 2 * n - 1; i >= n - 1; i--) {
            diff[i - n + 1] -= sumR;
            if (r.element() < nums[i]) {
                sumR += nums[i] - r.remove();
                r.add(nums[i]);
            }
        }
        long res = (long) 1e18;
        for (long curr : diff) {
            res = Math.min(res, curr);
        }
        return res;
    }
}
