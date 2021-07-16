package binarysearch.weekly_27;

public class P_2 {

    static boolean[][] seen;
    static int[][] dp;

    public int solve(int[] rod_lens, int profit_per_len, int cost_per_cut) {
        int max = 0;
        for (int rod : rod_lens) {
            max = Math.max(max, rod);
        }
        int res = 0;
        final int n = rod_lens.length;
        seen = new boolean[n][max + 1];
        dp = new int[n][max + 1];
        for (int i = 1; i <= max; i++) {
            res = Math.max(res, dfs(rod_lens, 0, profit_per_len, cost_per_cut, i));
        }
        return res;
    }

    private static int dfs(int[] arr, int idx, int pp, int cc, int max) {
        if (idx == arr.length) {
            return 0;
        }
        if (seen[idx][max]) {
            return dp[idx][max];
        }
        int res = 0;
        final int rod = arr[idx];
        final int p = rod / max;
        final int c = (rod % max == 0) ? p - 1 : p;
        res = Math.max(res, max * p * pp - c * cc + dfs(arr, idx + 1, pp, cc, max));
        res = Math.max(res, dfs(arr, idx + 1, pp, cc, max));
        seen[idx][max] = true;
        return dp[idx][max] = res;
    }

    public int solveGreedy(int[] rod_lens, int profit_per_len, int cost_per_cut) {
        int max = 0;
        for (int rod : rod_lens) {
            max = Math.max(max, rod);
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            int curr = 0;
            for (int rod : rod_lens) {
                final int p = rod / i;
                final int c = (rod % i == 0) ? p - 1 : p;
                final int best = i * p * profit_per_len - c * cost_per_cut;
                curr += Math.max(0, best);
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
