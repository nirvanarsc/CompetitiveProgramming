package leetcode.biweekly_contests.biweekly_88;

public class P_3 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        if (n % 2 != 0 && m % 2 != 0) {
            return f(nums1) ^ f(nums2);
        }
        if (n % 2 != 0) {
            return f(nums2);
        }
        if (m % 2 != 0) {
            return f(nums1);
        }
        return 0;
    }

    private static int f(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
