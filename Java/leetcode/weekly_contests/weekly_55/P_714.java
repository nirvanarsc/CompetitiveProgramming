package leetcode.weekly_contests.weekly_55;

public class P_714 {

    public int maxProfitBottomUp(int[] prices, int fee) {
        int res = 0, curr = (int) -1e9;

        for (int price : prices) {
            res = Math.max(res, curr + price - fee);
            curr = Math.max(curr, res - price);
        }

        return res;
    }

    public int maxProfit(int[] prices, int fee) {
        final int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return dfs(prices, 0, 0, fee, dp);
    }

    private static int dfs(int[] prices, int idx, int status, int fee, int[][] dp) {
        if (idx == prices.length) {
            return status == 1 ? (int) -1e9 : 0;
        }
        if (dp[idx][status] != -1) {
            return dp[idx][status];
        }
        int res = (int) -1e9;
        if (status == 1) {
            res = Math.max(res, prices[idx] - fee + dfs(prices, idx + 1, 0, fee, dp));
        } else {
            res = Math.max(res, -prices[idx] + dfs(prices, idx + 1, 1, fee, dp));
        }
        res = Math.max(res, dfs(prices, idx + 1, status, fee, dp));
        return dp[idx][status] = res;
    }
}
