package leetcode.biweekly_contests.biweekly_100_199.biweekly_119;

public class P_1 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        final boolean[] l = new boolean[105];
        final boolean[] r = new boolean[105];
        for (int num : nums1) {
            l[num] = true;
        }
        for (int num : nums2) {
            r[num] = true;
        }
        final int[] res = new int[2];
        for (int num : nums1) {
            if (r[num]) {
                res[0]++;
            }
        }
        for (int num : nums2) {
            if (l[num]) {
                res[1]++;
            }
        }
        return res;
    }
}
