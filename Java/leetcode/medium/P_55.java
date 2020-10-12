package leetcode.medium;

public class P_55 {

    public boolean canJump(int[] nums) {
        int currMax = 0;
        for (int j = 0; j < nums.length && j <= currMax; j++) {
            currMax = Math.max(currMax, j + nums[j]);
        }
        return currMax >= nums.length - 1;
    }

    public boolean canJumpTopDown(int[] nums) {
        final Boolean[] dp = new Boolean[nums.length];
        dp[nums.length - 1] = true;

        return recurse(0, nums, dp);
    }

    private static boolean recurse(int pos, int[] nums, Boolean[] memo) {
        if (memo[pos] != null) {
            return memo[pos];
        }

        final int furthest = Math.min(pos + nums[pos], nums.length - 1);
        boolean canReach = false;
        for (int i = furthest; i >= pos + 1; --i) {
            if (recurse(i, nums, memo)) {
                canReach = true;
                break;
            }
        }

        memo[pos] = canReach;
        return canReach;
    }
}
