package leetcode.weekly_contests.weekly_300_399.weekly_324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_3 {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        final int[] deg = new int[n];
        final Map<Integer, Set<Integer>> g = new HashMap<>();
        for (List<Integer> e : edges) {
            final int u = e.get(0) - 1;
            final int v = e.get(1) - 1;
            g.computeIfAbsent(u, val -> new HashSet<>()).add(v);
            g.computeIfAbsent(v, val -> new HashSet<>()).add(u);
            deg[u]++;
            deg[v]++;
        }
        final List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] % 2 != 0) {
                odd.add(i);
            }
        }
        if (odd.isEmpty()) {
            return true;
        }
        if (odd.size() == 2) {
            for (int i = 0; i < n; i++) {
                if (!odd.contains(i)
                    && f(g, Arrays.asList(odd.get(0), i))
                    && f(g, Arrays.asList(odd.get(1), i))) {
                    return true;
                }
            }
            return f(g, odd);
        }
        if (odd.size() == 4) {
            for (int mask = 0; mask < 1 << 4; mask++) {
                if (Integer.bitCount(mask) != 2) {
                    continue;
                }
                final List<Integer> l = new ArrayList<>(2);
                final List<Integer> r = new ArrayList<>(2);
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) {
                        l.add(odd.get(i));
                    } else {
                        r.add(odd.get(i));
                    }
                }
                if (f(g, l) && f(g, r)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean f(Map<Integer, Set<Integer>> g, List<Integer> odd) {
        return !g.get(odd.get(0)).contains(odd.get(1));
    }
}
