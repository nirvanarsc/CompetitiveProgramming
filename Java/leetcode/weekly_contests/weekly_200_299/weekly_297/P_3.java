package leetcode.weekly_contests.weekly_200_299.weekly_297;

public class P_3 {

    static int n;
    static int[] sum;
    static boolean[][][] seen;
    static int[][][] dp;

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        sum = new int[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum[mask] += cookies[i];
                }
            }
        }
        seen = new boolean[k][1 << n][1 << n];
        dp = new int[k][1 << n][1 << n];
        return dfs(0, 0, k, 0);
    }

    private static int dfs(int idx, int mask, int k, int max) {
        final int total = (1 << n) - 1;
        if (idx == k) {
            return mask == total ? sum[max] : (int) 1e9;
        }
        if (seen[idx][mask][max]) {
            return dp[idx][mask][max];
        }
        int res = (int) 1e9;

        final int other = total ^ mask;
        for (int subMask = other; subMask > 0; subMask = (subMask - 1) & other) {
            final int nextMask = sum[max] > sum[subMask] ? max : subMask;
            res = Math.min(res, dfs(idx + 1, mask | subMask, k, nextMask));
        }
        seen[idx][mask][max] = true;
        return dp[idx][mask][max] = res;
    }
}
