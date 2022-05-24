package leetcode.weekly_contests.weekly_200_299.weekly_265;

public class P_1 {

    public int smallestEqual(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
