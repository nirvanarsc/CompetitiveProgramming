package leetcode.biweekly_contests.biweekly_13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P_1258 {

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        final Map<String, List<String>> graph = new HashMap<>();
        for (List<String> s : synonyms) {
            graph.putIfAbsent(s.get(0), new LinkedList<>());
            graph.get(s.get(0)).add(s.get(1));
            graph.putIfAbsent(s.get(1), new LinkedList<>());
            graph.get(s.get(1)).add(s.get(0));
        }

        final Set<String> ans = new TreeSet<>();
        final Deque<String> q = new ArrayDeque<>();
        q.add(text);
        while (!q.isEmpty()) {
            final String out = q.remove();
            ans.add(out);
            final String[] words = out.split(" ");
            for (int i = 0; i < words.length; i++) {
                final String word = words[i];
                if (graph.containsKey(word)) {
                    for (String neighbor : graph.get(word)) {
                        words[i] = neighbor;
                        final String newText = String.join(" ", words);
                        if (!ans.contains(newText)) {
                            q.add(newText);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
