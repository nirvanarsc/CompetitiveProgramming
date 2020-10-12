package leetcode.weekly_contests.weekly_30;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_568 {

    public int maxVacationDaysDP(int[][] flights, int[][] days) {
        return dfs(flights, days, 0, 0, new Integer[flights.length][days[0].length]);
    }

    public int dfs(int[][] flights, int[][] days, int city, int week, Integer[][] dp) {
        if (week == days[0].length) {
            return 0;
        }
        if (dp[city][week] != null) {
            return dp[city][week];
        }
        int res = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[city][i] == 1 || i == city) {
                res = Math.max(res, days[i][week] + dfs(flights, days, i, week + 1, dp));
            }
        }
        return dp[city][week] = res;
    }

    static class City {
        int id;
        int holidays;

        City(int id, int holidays) {
            this.id = id;
            this.holidays = holidays;
        }
    }

    public int maxVacationDays(int[][] flights, int[][] days) {
        final int n = flights.length;
        final int k = days[0].length;
        final Comparator<City> comparator = (a, b) -> Integer.compare(b.holidays, a.holidays);
        PriorityQueue<City> pq = new PriorityQueue<>(comparator);
        pq.add(new City(0, 0));
        for (int week = 0; week < k; week++) {
            final boolean[] visited = new boolean[n];
            final PriorityQueue<City> nextHeap = new PriorityQueue<>(comparator);
            while (!pq.isEmpty() && nextHeap.size() < n) {
                final City origin = pq.poll();
                for (int next = 0; next < n; next++) {
                    if (!visited[next] && (next == origin.id || flights[origin.id][next] == 1)) {
                        nextHeap.add(new City(next, origin.holidays + days[next][week]));
                        visited[next] = true;
                    }
                }
            }
            pq = nextHeap;
        }
        return pq.remove().holidays;
    }
}
