package leetcode.weekly_contests.weekly_0_99.weekly_18b;

public class P_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        final int[] idx = new int[(int) (1e4 + 5)];
        final int[] stack = new int[m];
        final int[] next = new int[m];
        int sIdx = 0;
        for (int i = 0; i < m; i++) {
            idx[nums2[i]] = i;
        }
        for (int i = m - 1; i >= 0; i--) {
            while (sIdx > 0 && stack[sIdx - 1] < nums2[i]) {
                sIdx--;
            }
            next[i] = sIdx == 0 ? -1 : stack[sIdx - 1];
            stack[sIdx++] = nums2[i];
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = next[idx[nums1[i]]];
        }
        return res;
    }
}
