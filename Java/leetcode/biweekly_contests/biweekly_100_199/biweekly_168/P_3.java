package leetcode.biweekly_contests.biweekly_100_199.biweekly_168;

public class P_3 {

    public long minOperations(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        int diff = (int) 2e9;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int u = nums1[i];
            int v = nums2[i];
            res += Math.abs(u - v);
            if (u > v) {
                final int t = u;
                u = v;
                v = t;
            }
            if (nums2[n] < u) {
                diff = Math.min(diff, u - nums2[n]);
            } else if (v < nums2[n]) {
                diff = Math.min(diff, nums2[n] - v);
            } else {
                diff = 0;
            }
        }
        return res + diff + 1;
    }
}
