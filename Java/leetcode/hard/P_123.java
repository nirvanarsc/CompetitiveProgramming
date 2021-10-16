package leetcode.hard;

public class P_123 {

    public int maxProfitBottomUp(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        return profit2;
    }

    static boolean[][][] seen;
    static int[][][] dp;
    static int n;

    public int maxProfit(int[] prices) {
        n = prices.length;
        seen = new boolean[n][2][3];
        dp = new int[n][2][3];
        return dfs(prices, 0, 0, 2);
    }

    private static int dfs(int[] arr, int idx, int status, int k) {
        if (idx == n || k == 0) {
            return 0;
        }
        if (seen[idx][status][k]) {
            return dp[idx][status][k];
        }
        int res = 0;
        res = Math.max(res, dfs(arr, idx + 1, status, k));
        if (status == 0) {
            res = Math.max(res, -arr[idx] + dfs(arr, idx + 1, 1, k));
        } else if (status == 1) {
            res = Math.max(res, arr[idx] + dfs(arr, idx + 1, 0, k - 1));
        }
        seen[idx][status][k] = true;
        return dp[idx][status][k] = res;
    }
}
