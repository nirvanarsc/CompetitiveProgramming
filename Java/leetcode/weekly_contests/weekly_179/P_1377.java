package leetcode.weekly_contests.weekly_179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1377 {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        final double[] dp = new double[n + 1];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], v -> new ArrayList<>()).add(e[0]);
        }
        dp[1] = 1.0;
        dfs(1, -1, t, g, dp);
        return dp[target];
    }

    private static void dfs(int curr, int prev, int time, Map<Integer, List<Integer>> g, double[] dp) {
        final int size = g.getOrDefault(curr, Collections.emptyList()).size() - ((curr == 1) ? 0 : 1);
        if (size <= 0 || time == 0) {
            return;
        }
        final double portion = dp[curr] / size;
        dp[curr] = 0;
        for (int next : g.get(curr)) {
            if (next != prev) {
                dp[next] = portion;
                dfs(next, curr, time - 1, g, dp);
            }
        }
    }
}
