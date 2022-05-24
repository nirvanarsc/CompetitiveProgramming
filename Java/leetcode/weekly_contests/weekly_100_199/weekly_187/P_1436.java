package leetcode.weekly_contests.weekly_100_199.weekly_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1436 {

    public String destCity(List<List<String>> paths) {
        final Set<String> cities = new HashSet<>();
        final Map<String, List<String>> g = new HashMap<>();
        for (List<String> l : paths) {
            g.computeIfAbsent(l.get(0), v -> new ArrayList<>()).add(l.get(1));
            cities.add(l.get(0));
            cities.add(l.get(1));
        }
        for (String city : cities) {
            if (!g.containsKey(city)) {
                return city;
            }
        }
        return "";
    }
}
