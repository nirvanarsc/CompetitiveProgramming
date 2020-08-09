package weekly_contests.weekly_201;

import java.util.Arrays;

public class P_1547 {

    public int minCost(int n, int[] cuts) {
        final int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        System.arraycopy(cuts, 0, arr, 1, cuts.length);
        Arrays.sort(arr);
        return dfs(arr, 0, arr.length - 1, new Integer[arr.length][arr.length]);
    }

    private static int dfs(int[] cuts, int l, int r, Integer[][] dp) {
        if (l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int res = (int) 1e9;
        for (int i = l + 1; i < r; i++) {
            res = Math.min(res, dfs(cuts, l, i, dp) + dfs(cuts, i, r, dp));
        }
        return dp[l][r] = res + cuts[r] - cuts[l];
    }
}
