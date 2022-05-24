package leetcode.weekly_contests.weekly_100_199.weekly_187;

public class P_1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int max = (int) 1e9;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && j == -1) {
                j = i;
            } else if (nums[i] == 1) {
                max = Math.min(max, i - j - 1);
                j = i;
            }
        }
        return max >= k;
    }
}
