package medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_737 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
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
            if (!words1[i].equals(words2[i])) {
                if (!bfs(words1[i], words2[i], graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(String word1, String word2, Map<String, Set<String>> graph) {
        final Deque<String> q = new ArrayDeque<>(graph.getOrDefault(word1, Collections.emptySet()));
        final Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            final String curr = q.removeFirst();
            visited.add(curr);
            if (curr.equals(word2)) {
                return true;
            }
            for (String neighbour : graph.getOrDefault(curr, Collections.emptySet())) {
                if (!visited.contains(neighbour)) {
                    q.offerLast(neighbour);
                }
            }
        }
        return false;
    }
}
