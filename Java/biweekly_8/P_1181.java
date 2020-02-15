package biweekly_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P_1181 {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        final Map<String, Set<String>> head = new HashMap<>();
        final Map<String, Set<String>> tail = new HashMap<>();
        final Map<String, Integer> count = new HashMap<>();
        for (String p : phrases) {
            final String[] sa = p.split(" ");
            head.computeIfAbsent(sa[0], s -> new HashSet<>()).add(p);
            tail.computeIfAbsent(sa[sa.length - 1], s -> new HashSet<>()).add(p);
            count.merge(p, 1, Integer::sum);
        }
        final TreeSet<String> ans = new TreeSet<>();
        for (Map.Entry<String, Set<String>> entry : tail.entrySet()) {
            final String end = entry.getKey();
            for (String p : head.getOrDefault(end, Collections.emptySet())) {
                for (String t : entry.getValue()) {
                    if (!t.equals(p) || count.get(p) > 1) {
                        ans.add(t + p.substring(end.length()));
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
