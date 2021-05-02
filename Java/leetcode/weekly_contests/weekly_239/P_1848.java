package leetcode.weekly_contests.weekly_239;

public class P_1848 {

    public int getMinDistance(int[] nums, int target, int start) {
        int res = (int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}
