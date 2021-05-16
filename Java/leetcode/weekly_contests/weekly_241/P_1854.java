package leetcode.weekly_contests.weekly_241;

public class P_1854 {

    public int subsetXORSum(int[] nums) {
        int res = 0;
        final int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr ^= nums[i];
                }
            }
            res += curr;
        }
        return res;
    }
}
