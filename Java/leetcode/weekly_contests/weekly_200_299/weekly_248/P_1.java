package leetcode.weekly_contests.weekly_200_299.weekly_248;

public class P_1 {

    public int[] buildArray(int[] nums) {
        final int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
