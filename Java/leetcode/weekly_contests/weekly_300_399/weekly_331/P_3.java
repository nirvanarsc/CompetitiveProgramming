package leetcode.weekly_contests.weekly_300_399.weekly_331;

public class P_3 {

    static boolean[] seen;
    static int[] dp;

    public int minCapability(int[] nums, int k) {
        int lo = 0;
        int hi = (int) 1e9;
        final int n = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            seen = new boolean[n];
            dp = new int[n];
            final int v = dfs(nums, 0, mid);
            if (v < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int dfs(int[] nums, int idx, int mid) {
        if (idx >= nums.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 0;
        if (nums[idx] <= mid) {
            res = Math.max(res, 1 + dfs(nums, idx + 2, mid));
        }
        res = Math.max(res, dfs(nums, idx + 1, mid));
        seen[idx] = true;
        return dp[idx] = res;
    }
}
