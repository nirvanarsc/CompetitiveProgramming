package leetcode.easy;

public class P_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        for (int idx = m + n - 1; idx >= 0; idx--) {
            if (l >= 0 && r >= 0) {
                if (nums1[l] > nums2[r]) {
                    nums1[idx] = nums1[l--];
                } else {
                    nums1[idx] = nums2[r--];
                }
            } else if (l >= 0) {
                nums1[idx] = nums1[l--];
            } else {
                nums1[idx] = nums2[r--];
            }
        }
    }
}
