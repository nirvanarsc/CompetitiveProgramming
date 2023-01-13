package leetcode.weekly_contests.weekly_300_399.weekly_327;

public class P_1 {

    public int maximumCount(int[] nums) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            if (num > 0) {
                l++;
            } else if (num < 0) {
                r++;
            }
        }
        return Math.max(l, r);
    }
}
