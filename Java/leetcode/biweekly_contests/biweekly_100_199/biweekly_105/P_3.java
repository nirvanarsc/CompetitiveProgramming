package leetcode.biweekly_contests.biweekly_100_199.biweekly_105;

public class P_3 {

    public long maxStrength(int[] nums) {
        final int n = nums.length;
        long res = (long) -9e18;
        for (int mask = 1; mask < (1 << n); mask++) {
            long curr = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr *= nums[i];
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
