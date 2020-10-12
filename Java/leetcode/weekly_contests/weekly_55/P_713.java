package leetcode.weekly_contests.weekly_55;

public class P_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int p = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            p *= nums[j];
            while (i <= j && p >= k) {
                p /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}
