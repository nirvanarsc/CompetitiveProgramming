package leetcode.biweekly_contests.biweekly_0_99.biweekly_96;

public class P_2 {

    public long minOperations(int[] nums1, int[] nums2, int k) {
        final int n = nums1.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] % k != nums2[i] % k) {
                return -1;
            }
        }
        long l = 0;
        long r = 0;
        for (int i = 0; i < n; i++) {
            if (nums2[i] > nums1[i]) {
                l += (nums2[i] - nums1[i]) / k;
            } else {
                r += (nums1[i] - nums2[i]) / k;
            }
        }
        return l != r ? -1 : l;
    }
}
