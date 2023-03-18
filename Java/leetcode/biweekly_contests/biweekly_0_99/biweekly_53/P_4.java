package leetcode.biweekly_contests.biweekly_0_99.biweekly_53;

public class P_4 {

    static int[][] dp;
    static boolean[][] seen;

    public int minimumXORSum(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        dp = new int[n][1 << n];
        seen = new boolean[n][1 << n];
        return dfs(nums1, nums2, 0, 0);
    }

    private static int dfs(int[] l, int[] r, int idx, int mask) {
        if (idx == l.length) {
            return 0;
        }
        if (seen[idx][mask]) {
            return dp[idx][mask];
        }
        int res = (int) 1e9;
        for (int i = 0; i < r.length; i++) {
            if ((mask & (1 << i)) == 0) {
                res = Math.min(res, (l[idx] ^ r[i]) + dfs(l, r, idx + 1, mask | (1 << i)));
            }
        }
        seen[idx][mask] = true;
        return dp[idx][mask] = res;
    }
}
