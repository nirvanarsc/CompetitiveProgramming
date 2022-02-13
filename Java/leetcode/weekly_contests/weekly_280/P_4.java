package leetcode.weekly_contests.weekly_280;

public class P_4 {

    static int n;
    static int m;
    static boolean[][] seen;
    static int[][] dp;

    public int maximumANDSum(int[] nums, int numSlots) {
        n = nums.length;
        m = 2 * numSlots;
        seen = new boolean[n][1 << m];
        dp = new int[n][1 << m];
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int idx, int mask) {
        if (idx == n) {
            return 0;
        }
        if (seen[idx][mask]) {
            return dp[idx][mask];
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) == 0) {
                res = Math.max(res, ((1 + (i / 2)) & nums[idx]) + dfs(nums, idx + 1, mask | 1 << i));
            }
        }
        seen[idx][mask] = true;
        return dp[idx][mask] = res;
    }
}
