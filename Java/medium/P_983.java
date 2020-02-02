package medium;

public class P_983 {

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

    public int mincostTickets(int[] days, int[] costs) {
        return minCost(days, costs, 0, new Integer[days.length]);
    }

    private static int minCost(int[] days, int[] costs, int pos, Integer[] dp) {
        if (pos == days.length) {
            return 0;
        }
        if (dp[pos] != null) {
            return dp[pos];
        }

        final int OneDay = costs[0] + minCost(days, costs, pos + 1, dp);
        int increment = 0;
        int initial = days[pos];
        while (pos + increment < days.length - 1 && days[pos + increment + 1] - initial < 7) {
            increment++;
        }
        final int SevenDay = costs[1] + minCost(days, costs, pos + increment + 1, dp);
        increment = 0;
        initial = days[pos];
        while (pos + increment < days.length - 1 && days[pos + increment + 1] - initial < 30) {
            increment++;
        }
        final int ThirtyDay = costs[2] + minCost(days, costs, pos + increment + 1, dp);

        return dp[pos] = Math.min(OneDay, Math.min(SevenDay, ThirtyDay));
    }
}
