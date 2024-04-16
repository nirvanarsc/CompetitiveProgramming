package leetcode.weekly_contests.weekly_300_399.weekly_392;

public class P_1 {

    public int longestMonotonicSubarray(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j - 1] < nums[j]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j - 1] > nums[j]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
