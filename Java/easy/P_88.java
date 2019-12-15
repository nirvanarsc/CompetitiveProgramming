package easy;

public class P_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                nums1[i] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            } else if (n >= 0) {
                nums1[i] = nums2[n--];
            }
        }
    }
}
