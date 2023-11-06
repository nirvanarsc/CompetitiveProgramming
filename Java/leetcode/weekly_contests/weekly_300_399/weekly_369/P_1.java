package leetcode.weekly_contests.weekly_300_399.weekly_369;

public class P_1 {

    public int findKOr(int[] nums, int k) {
        final int[] f = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                f[i] += ((num & (1 << i)) != 0) ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (f[i] >= k) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
