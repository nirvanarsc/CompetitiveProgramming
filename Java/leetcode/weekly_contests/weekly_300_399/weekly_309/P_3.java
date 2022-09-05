package leetcode.weekly_contests.weekly_300_399.weekly_309;

public class P_3 {

    public int longestNiceSubarray(int[] nums) {
        final int n = nums.length;
        final int[] mask = new int[31];
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!inc(nums[i], mask)) {
                //noinspection StatementWithEmptyBody
                while (!dec(nums[j++], mask)) { }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    private static boolean inc(int num, int[] mask) {
        for (int k = 0; k < 31; k++) {
            if ((num & (1 << k)) != 0) {
                ++mask[k];
            }
        }
        return isOk(mask);
    }

    private static boolean dec(int num, int[] mask) {
        for (int k = 0; k < 31; k++) {
            if ((num & (1 << k)) != 0) {
                --mask[k];
            }
        }
        return isOk(mask);
    }

    private static boolean isOk(int[] mask) {
        for (int i = 0; i < 31; i++) {
            if (mask[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
