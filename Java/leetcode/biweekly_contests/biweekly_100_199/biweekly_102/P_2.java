package leetcode.biweekly_contests.biweekly_100_199.biweekly_102;

public class P_2 {

    public long[] findPrefixScore(int[] nums) {
        final int n = nums.length;
        final long[] res = new long[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            res[i] = nums[i] + max;
            if (i > 0) {
                res[i] += res[i - 1];
            }
        }
        return res;
    }
}
