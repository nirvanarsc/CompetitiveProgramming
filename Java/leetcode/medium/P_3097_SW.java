package leetcode.medium;

public class P_3097_SW {

    public int minimumSubarrayLength(int[] nums, int k) {
        final int[] bits = new int[30];
        int res = (int) 1e9;
        int j = 0;
        final int n = nums.length;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr |= nums[i];
            for (int l = 0; l < 30; l++) {
                if ((nums[i] & (1 << l)) != 0) {
                    bits[l]++;
                }
            }
            while (i - j >= 0 && curr >= k) {
                for (int l = 0; l < 30; l++) {
                    if ((nums[j] & (1 << l)) != 0) {
                        if (--bits[l] == 0) {
                            curr ^= 1 << l;
                        }
                    }
                }
                res = Math.min(res, i - j + 1);
                j++;
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
