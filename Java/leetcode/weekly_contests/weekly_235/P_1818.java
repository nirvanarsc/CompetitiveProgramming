package leetcode.weekly_contests.weekly_235;

import java.util.TreeSet;

public class P_1818 {

    private static final int MOD = (int) (1e9 + 7);

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums1) {
            ts.add(num);
        }
        final int n = nums1.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        long best = sum;
        for (int i = 0; i < n; i++) {
            final long curr = sum - Math.abs(nums1[i] - nums2[i]);
            final Integer up = ts.ceiling(nums2[i]);
            final Integer down = ts.floor(nums2[i]);
            if (up != null) {
                best = Math.min(best, curr + Math.abs(up - nums2[i]));
            }
            if (down != null) {
                best = Math.min(best, curr + Math.abs(down - nums2[i]));
            }
        }
        return (int) (best % MOD);
    }
}
