package leetcode.weekly_contests.weekly_300_399.weekly_371;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        final Map<String, List<Integer>> g = new HashMap<>();
        for (List<String> access : access_times) {
            g.computeIfAbsent(access.get(0), val -> new ArrayList<>()).add(f(access.get(1)));
        }
        final List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : g.entrySet()) {
            final List<Integer> list = e.getValue();
            list.sort(Comparator.naturalOrder());
            final int n = list.size();
            for (int i = 0; i < n - 2; i++) {
                if (list.get(i + 2) - list.get(i) < 60) {
                    res.add(e.getKey());
                    break;
                }
            }
        }
        return res;
    }

    private static int f(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(2));
    }
}
