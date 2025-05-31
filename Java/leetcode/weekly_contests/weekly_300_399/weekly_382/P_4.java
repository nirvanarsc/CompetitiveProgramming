package leetcode.weekly_contests.weekly_300_399.weekly_382;

public class P_4 {

    public int minOrAfterOperations(int[] nums, int k) {
        final int res = (1 << 30) - 1;
        final int groups = nums.length - k;
        int mask = 0;
        for (int i = 29; i >= 0; i--) {
            if (f(nums, groups, mask | 1 << i)) {
                mask |= 1 << i;
            }
        }
        return res ^ mask;
    }

    private static boolean f(int[] nums, int groups, int mask) {
        int t = mask;
        for (int x : nums) {
            t &= x;
            if (t == 0) {
                if (--groups == 0) {
                    return true;
                }
                t = mask;
            }
        }
        return false;
    }
}
