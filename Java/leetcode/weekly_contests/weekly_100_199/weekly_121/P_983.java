package leetcode.weekly_contests.weekly_100_199.weekly_121;

public class P_983 {

    static boolean[] seen;
    static int[] dp;
    static int[][] c;

    public int mincostTickets(int[] days, int[] costs) {
        seen = new boolean[400];
        dp = new int[400];
        c = new int[][] { { costs[0], 0 }, { costs[1], 6 }, { costs[2], 29 } };
        return dfs(days, 0, 0);
    }

    private static int dfs(int[] days, int ticket, int idx) {
        if (idx == days.length) {
            return 0;
        }
        if (seen[ticket]) {
            return dp[ticket];
        }
        int res = (int) 1e9;
        if (days[idx] > ticket) {
            for (int[] c : c) {
                res = Math.min(res, c[0] + dfs(days, days[idx] + c[1], idx + 1));
            }
        } else {
            res = dfs(days, ticket, idx + 1);
        }
        seen[ticket] = true;
        return dp[ticket] = res;
    }

    public int mincostTicketsBottomUp(int[] days, int[] costs) {
        final int n = days[days.length - 1];
        final boolean[] travel = new boolean[n + 1];
        final int[] amount = new int[n + 1];
        for (int day : days) {
            travel[day] = true;
        }
        for (int i = 1; i <= n; ++i) {
            if (travel[i]) {
                int min = amount[i - 1] + costs[0];
                min = Math.min(min, (i < 7 ? 0 : amount[i - 7]) + costs[1]);
                min = Math.min(min, (i < 30 ? 0 : amount[i - 30]) + costs[2]);
                amount[i] = min;
            } else {
                amount[i] = amount[i - 1];
            }
        }
        return amount[n];
    }

    public int mincostTicketsTopDown(int[] days, int[] costs) {
        return minCost(days, costs, 0, new Integer[days.length]);
    }

    private static int minCost(int[] days, int[] costs, int pos, Integer[] dp) {
        if (pos == days.length) {
            return 0;
        }
        if (dp[pos] != null) {
            return dp[pos];
        }

        int i1 = 0;
        int i2 = 0;
        while (pos + i1 < days.length - 1 && days[pos + i1 + 1] - days[pos] < 7) { i1++; }
        while (pos + i2 < days.length - 1 && days[pos + i2 + 1] - days[pos] < 30) { i2++; }

        final int OneDay = costs[0] + minCost(days, costs, pos + 1, dp);
        final int SevenDay = costs[1] + minCost(days, costs, pos + i1 + 1, dp);
        final int ThirtyDay = costs[2] + minCost(days, costs, pos + i2 + 1, dp);

        return dp[pos] = Math.min(OneDay, Math.min(SevenDay, ThirtyDay));
    }
}
