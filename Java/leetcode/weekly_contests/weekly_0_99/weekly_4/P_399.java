package leetcode.weekly_contests.weekly_0_99.weekly_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_399 {

    private static class Pair {
        String other;
        double ratio;

        Pair(String other, double ratio) {
            this.other = other;
            this.ratio = ratio;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, List<Pair>> g = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            final String u = equations.get(i).get(0);
            final String v = equations.get(i).get(1);
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(new Pair(v, values[i]));
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(new Pair(u, 1.0 / values[i]));
        }
        final double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            final String u = queries.get(i).get(0);
            final String v = queries.get(i).get(1);
            if (!g.containsKey(u) || !g.containsKey(v)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(g, u, v, new HashSet<>());
            }
        }
        return res;
    }

    private static double dfs(Map<String, List<Pair>> g, String curr, String target, Set<String> seen) {
        if (curr.equals(target)) {
            return 1.0;
        }
        seen.add(curr);
        for (Pair next : g.getOrDefault(curr, Collections.emptyList())) {
            if (seen.add(next.other)) {
                final double dfs = dfs(g, next.other, target, seen);
                if (Double.compare(dfs, -1.0) != 0) {
                    return next.ratio * dfs;
                }
            }
        }
        return -1.0;
    }
}
