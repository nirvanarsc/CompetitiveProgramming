package leetcode.weekly_contests.weekly_13;

import java.util.Arrays;

public class P_473 {

    public boolean makesquare(int[] nums) {
        final int sum = Arrays.stream(nums).sum();
        final int side = sum / 4;
        if (side * 4 != sum) {
            return false;
        }
        Arrays.sort(nums);
        return dfs(nums, (1 << nums.length) - 1, side, 0, 0);
    }

    private static boolean dfs(int[] nums, int used, int target, int curr, int sides) {
        if (used == 0) {
            return sides == 4;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((used & (1 << i)) != 0) {
                if (nums[i] + curr > target) {
                    return false;
                }
                if (dfs(nums, used ^ 1 << i, target, (curr + nums[i]) % target,
                        (curr + nums[i]) / target + sides)) {
                    return true;
                }
            }
        }
        return false;
    }
}
