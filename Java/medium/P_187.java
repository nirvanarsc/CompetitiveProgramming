package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        final Set<String> res = new HashSet<>();
        final Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            final String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                res.add(sub);
            }
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        final Map<String, Integer> map = new HashMap<>();
        final List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            map.merge(s.substring(i, i + 10), 1, Integer::sum);
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
