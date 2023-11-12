package leetcode.weekly_contests.weekly_300_399.weekly_371;

public class P_3 {

    public int minOperations(int[] nums1, int[] nums2) {
        final int[] copy1 = nums1.clone();
        final int[] copy2 = nums2.clone();
        final int n = nums1.length;
        copy1[n - 1] = nums2[n - 1];
        copy2[n - 1] = nums1[n - 1];
        final int res = Math.min(f(nums1, nums2, n), f(copy1, copy2, n) + 1);
        return res >= (int) 1e9 ? -1 : res;
    }

    private static int f(int[] l, int[] r, int n) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (l[i] > l[n - 1] || r[i] > r[n - 1]) {
                if (l[i] > r[n - 1] || r[i] > l[n - 1]) {
                    return (int) 1e9;
                }
                res++;
            }
        }
        return res;
    }
}
