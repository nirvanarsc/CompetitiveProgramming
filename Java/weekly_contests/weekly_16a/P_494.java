package weekly_contests.weekly_16a;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_494 {

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, S, new Integer[nums.length][2001]);
    }

    private static int dfs(int[] nums, int i, int curr, int S, Integer[][] dp) {
        if (i == nums.length) {
            return curr == S ? 1 : 0;
        }
        if (dp[i][curr + 1000] != null) {
            return dp[i][curr + 1000];
        }

        final int add = dfs(nums, i + 1, curr + nums[i], S, dp);
        final int subtract = dfs(nums, i + 1, curr - nums[i], S, dp);

        return dp[i][curr + 1000] = add + subtract;
    }
}
