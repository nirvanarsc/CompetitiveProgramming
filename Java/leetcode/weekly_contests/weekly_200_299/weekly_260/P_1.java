package leetcode.weekly_contests.weekly_200_299.weekly_260;

public class P_1 {

    public int maximumDifference(int[] nums) {
        int res = (int) -2e9;
        int min = (int) 1e9;
        for (int num : nums) {
            min = Math.min(min, num);
            res = Math.max(res, num - min);
        }
        return res > 0 ? res : -1;
    }
}
