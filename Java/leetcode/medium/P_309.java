package leetcode.medium;

public class P_309 {

    public int maxProfitBottomUp(int[] prices) {
        int sell = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int reset = 0;
        for (int price : prices) {
            final int preSell = sell;
            sell = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, preSell);
        }
        return Math.max(sell, reset);
    }

    static boolean[][] seen;
    static int[][] dp;

    public int maxProfit(int[] prices) {
        final int n = prices.length;
        seen = new boolean[n][3];
        dp = new int[n][3];
        return dfs(prices, 0, 0);
    }

    private static int dfs(int[] arr, int idx, int status) {
        if (idx == arr.length) {
            return 0;
        }
        if (seen[idx][status]) {
            return dp[idx][status];
        }
        int res = 0;
        res = Math.max(res, dfs(arr, idx + 1, status == 2 ? 0 : status));
        if (status == 0) {
            res = Math.max(res, -arr[idx] + dfs(arr, idx + 1, 1));
        } else if (status == 1) {
            res = Math.max(res, arr[idx] + dfs(arr, idx + 1, 2));
        }
        seen[idx][status] = true;
        return dp[idx][status] = res;
    }
}
