package leetcode.weekly_contests.weekly_300_399.weekly_352;

public class P_1 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int j = i + 1;
                int expected = 1;
                while (j < n && nums[j] % 2 == expected && nums[j] <= threshold) {
                    j++;
                    expected ^= 1;
                }
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        return res;
    }
}
