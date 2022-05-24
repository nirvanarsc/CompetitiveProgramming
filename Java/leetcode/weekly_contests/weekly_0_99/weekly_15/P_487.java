package leetcode.weekly_contests.weekly_0_99.weekly_15;

public class P_487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        return findMaxConsecutiveOnes(nums, 1);
    }

    public int findMaxConsecutiveOnes(int[] nums, int k) {
        int j = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= nums[i] == 1 ? 0 : 1;
            while (k < 0) {
                k += nums[j++] == 1 ? 0 : 1;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
