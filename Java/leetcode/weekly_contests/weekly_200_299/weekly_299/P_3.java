package leetcode.weekly_contests.weekly_200_299.weekly_299;

public class P_3 {

    static int n;
    static boolean[][] seen;
    static int[][] dp;

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        n = nums1.length;
        seen = new boolean[n][3];
        dp = new int[n][3];
        final int l = dfs(nums1, nums2, 0, 0);
        seen = new boolean[n][3];
        dp = new int[n][3];
        return Math.max(l, dfs(nums2, nums1, 0, 0));
    }

    private static int dfs(int[] l, int[] r, int idx, int status) {
        if (idx == n) {
            return status != 0 ? 0 : (int) -1e9;
        }
        if (seen[idx][status]) {
            return dp[idx][status];
        }
        int res = (int) -1e9;
        if (status == 0) {
            res = Math.max(res, l[idx] + dfs(l, r, idx + 1, 0));
            res = Math.max(res, r[idx] + dfs(l, r, idx + 1, 1));
        } else if (status == 1) {
            res = Math.max(res, r[idx] + dfs(l, r, idx + 1, 1));
            res = Math.max(res, l[idx] + dfs(l, r, idx + 1, 2));
        } else {
            res = Math.max(res, l[idx] + dfs(l, r, idx + 1, 2));
        }
        seen[idx][status] = true;
        return dp[idx][status] = res;
    }

}
