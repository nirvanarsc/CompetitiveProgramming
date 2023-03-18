package leetcode.biweekly_contests.biweekly_0_99.biweekly_82;

import java.util.Arrays;

public class P_3 {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        final int n = nums1.length;
        for (int i = 0; i < n; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(nums1);
        boolean ok = true;
        for (int i = n - 1; i >= 0; i--) {
            final int p = i > 0 ? nums1[i - 1] : 0;
            final int d = nums1[i] - p;
            final long need = (long) (n - i) * d;
            if (need <= k) {
                k -= need;
            } else {
                final int u = nums1[i];
                final int l = k / (n - i);
                int r = k % (n - i);
                for (int j = i; j < n; j++) {
                    nums1[j] = u - l - (r-- > 0 ? 1 : 0);
                }
                ok = false;
                break;
            }
        }
        if (ok) {
            return 0;
        }
        long res = 0;
        for (int num : nums1) {
            res += (long) num * num;
        }
        return res;
    }
}
