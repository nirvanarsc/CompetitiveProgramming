package weekly_contests.weekly_185;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        final Map<Integer, Map<String, Integer>> map = new HashMap<>();
        final Set<String> dishes = new HashSet<>();
        for (List<String> o : orders) {
            map.computeIfAbsent(Integer.parseInt(o.get(1)), v -> new HashMap<>())
               .merge(o.get(2), 1, Integer::sum);
            dishes.add(o.get(2));
        }
        final List<String> sortedDish = new ArrayList<>(dishes);
        final List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(sortedDish);
        Collections.sort(tables);
        final List<List<String>> res = new ArrayList<>();
        for (Integer table : tables) {
            final List<String> append = new ArrayList<>(Collections.singleton(String.valueOf(table)));
            final Map<String, Integer> currTable = map.get(table);
            for (String s : sortedDish) {
                append.add(String.valueOf(currTable.getOrDefault(s, 0)));
            }
            res.add(append);
        }
        sortedDish.add(0, "Table");
        res.add(0, sortedDish);
        return res;
    }
}
