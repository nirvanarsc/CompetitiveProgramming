package leetcode.biweekly_contests.biweekly_96;

public class P_1 {

    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        final int n = nums1.length;
        final int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                return nums1[i];
            }
        }
        return -1;
    }
}
