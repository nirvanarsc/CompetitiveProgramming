package leetcode.weekly_contests.weekly_300_399.weekly_331;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public long minCost(int[] basket1, int[] basket2) {
        final Map<Integer, Integer> f1 = new HashMap<>();
        final Map<Integer, Integer> f2 = new HashMap<>();
        for (int b : basket1) { f1.merge(b, 1, Integer::sum); }
        for (int b : basket2) { f2.merge(b, 1, Integer::sum); }
        int min = (int) 2e9;
        for (Map.Entry<Integer, Integer> e : f1.entrySet()) {
            final int u = e.getKey();
            final int common = Math.min(e.getValue(), f2.getOrDefault(u, 0));
            f1.merge(u, -common, Integer::sum);
            f2.merge(u, -common, Integer::sum);
            if (common > 0) {
                min = Math.min(min, u);
            }
        }
        f1.entrySet().removeIf(e -> e.getValue() == 0);
        f2.entrySet().removeIf(e -> e.getValue() == 0);
        for (int k : f1.keySet()) {
            if (f2.containsKey(k)) {
                return -1;
            }
        }
        if (f(f1) || f(f2)) {
            return -1;
        }
        final List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : f1.entrySet()) {
            for (int i = 0; i < e.getValue() / 2; i++) {
                list.add(e.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> e : f2.entrySet()) {
            for (int i = 0; i < e.getValue() / 2; i++) {
                list.add(e.getKey());
            }
        }
        list.sort(Comparator.naturalOrder());
        min = Math.min(min, list.isEmpty() ? (int) 2e9 : list.get(0));
        long res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            res += Math.min(2L * min, list.get(i));
        }
        return res;
    }

    private static boolean f(Map<Integer, Integer> map) {
        for (int v : map.values()) {
            if (v % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
