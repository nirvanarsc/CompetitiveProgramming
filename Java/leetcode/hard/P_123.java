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

    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;
        seen = new boolean[n][2][k + 1];
        dp = new int[n][2][k + 1];
        return dfs(prices, 0, 0, k);
    }

    private static int dfs(int[] arr, int idx, int hasStock, int k) {
        if (idx == arr.length || k == 0) {
            return hasStock == 0 ? 0 : (int) -1e9;
        }
        if (seen[idx][hasStock][k]) {
            return dp[idx][hasStock][k];
        }
        int res = (int) -1e9;
        if (hasStock == 0) {
            res = Math.max(res, dfs(arr, idx + 1, 0, k));
            res = Math.max(res, -arr[idx] + dfs(arr, idx + 1, 1, k));
        } else {
            res = Math.max(res, dfs(arr, idx + 1, 1, k));
            res = Math.max(res, arr[idx] + dfs(arr, idx + 1, 0, k - 1));
        }
        seen[idx][hasStock][k] = true;
        return dp[idx][hasStock][k] = res;
    }
}
