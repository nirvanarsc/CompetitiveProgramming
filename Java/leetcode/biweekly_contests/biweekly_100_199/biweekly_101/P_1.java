package leetcode.biweekly_contests.biweekly_100_199.biweekly_101;

import java.util.Arrays;

public class P_1 {

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int mask = 0;
        for (int num : nums1) {
            mask |= 1 << num;
        }
        for (int num : nums2) {
            if ((mask & (1 << num)) != 0) {
                return num;
            }
        }
        return Math.min(10 * nums1[0] + nums2[0], 10 * nums2[0] + nums1[0]);
    }
}
