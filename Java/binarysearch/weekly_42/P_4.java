package binarysearch.weekly_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public int solve(String[] itinerary, String[][] edges) {
        final Map<String, Integer> map = new HashMap<>();
        final List<String> map2 = new ArrayList<>();
        int n = 0;
        for (String[] e : edges) {
            for (String u : e) {
                if (!map.containsKey(u)) {
                    map.put(u, n++);
                    map2.add(u);
                }
            }
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (String[] e : edges) {
            final int u = map.get(e[0]);
            final int v = map.get(e[1]);
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
        }
        final int m = itinerary.length;
        final int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = diff(itinerary[m - 1], map2.get(i));
        }
        for (int idx = m - 2; idx >= 0; idx--) {
            for (int u = 0; u < n; u++) {
                for (int v : g.getOrDefault(u, Collections.emptyList())) {
                    final int cost = diff(itinerary[idx], map2.get(u));
                    dp[u][idx] = Math.min(dp[u][idx], dp[v][idx + 1] + cost);
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i][0]);
        }
        return res;
    }

    private static int diff(String l, String r) {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            if (l.charAt(i) != r.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
