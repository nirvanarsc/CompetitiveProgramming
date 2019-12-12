package medium;

public class P_55 {

    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; ++i) {
            reach = Math.max(i + nums[i], reach);
        }
        return i == nums.length;
    }

    public boolean canJump2(int[] nums) {
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
