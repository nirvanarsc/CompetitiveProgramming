package easy;

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
        final Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> s : pairs) {
            graph.putIfAbsent(s.get(0), new HashSet<>());
            graph.get(s.get(0)).add(s.get(1));
            graph.putIfAbsent(s.get(1), new HashSet<>());
            graph.get(s.get(1)).add(s.get(0));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) &&
                !graph.getOrDefault(words1[i], Collections.emptySet()).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}
