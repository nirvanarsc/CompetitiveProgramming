package leetcode.weekly_contests.weekly_300_399.weekly_312;

public class P_2 {

    public int longestSubarray(int[] nums) {
        final int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                int j = i;
                while (j < n && nums[j] == nums[i]) {
                    j++;
                }
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        return res;
    }
}
