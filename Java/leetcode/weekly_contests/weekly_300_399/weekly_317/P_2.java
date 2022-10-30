package leetcode.weekly_contests.weekly_300_399.weekly_317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        final int n = creators.length;
        long max = 0;
        final Map<String, Long> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            max = Math.max(max, f.merge(creators[i], (long) views[i], Long::sum));
        }
        final Map<String, Integer> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (max == f.get(creators[i])) {
                final Integer u = g.get(creators[i]);
                if (u != null && views[u] < views[i]) {
                    g.put(creators[i], i);
                } else if (u != null && views[u] == views[i] && ids[i].compareTo(ids[u]) <= 0) {
                    g.put(creators[i], i);
                } else if (u == null) {
                    g.put(creators[i], i);
                }
            }
        }
        final List<List<String>> res = new ArrayList<>();
        for (int v : g.values()) {
            res.add(Arrays.asList(creators[v], ids[v]));
        }
        return res;
    }
}
