package weekly_contests.weekly_60;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_734 {

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        final Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            map.computeIfAbsent(pair.get(0), v -> new HashSet<>()).add(pair.get(1));
            map.computeIfAbsent(pair.get(1), v -> new HashSet<>()).add(pair.get(0));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) &&
                !map.getOrDefault(words1[i], Collections.emptySet()).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}
