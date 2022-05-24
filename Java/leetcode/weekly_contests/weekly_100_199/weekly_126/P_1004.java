package leetcode.weekly_contests.weekly_100_199.weekly_126;

public class P_1004 {

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= nums[i] == 0 ? 1 : 0;
            while (k < 0) {
                k += nums[j++] == 0 ? 1 : 0;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
