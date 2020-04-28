package weekly_contests.weekly_41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class P_642 {

    static class AutocompleteSystem {

        static class Trie {
            Map<String, Integer> tm = new HashMap<>();
            Trie[] children = new Trie[33];
        }

        StringBuilder sb = new StringBuilder();
        Trie root;
        Trie curr;

        AutocompleteSystem(String[] sentences, int[] times) {
            root = new Trie();
            for (int i = 0; i < sentences.length; i++) {
                insertWord(sentences[i], times[i]);
            }
            curr = root;
        }

        private void insertWord(String w, int times) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter != root) {
                    iter.tm.merge(w, times, Integer::sum);
                }
                if (iter.children[c == ' ' ? ' ' : c - 'a'] == null) {
                    iter.children[c == ' ' ? ' ' : c - 'a'] = new Trie();
                }
                iter = iter.children[c == ' ' ? ' ' : c - 'a'];
            }
            iter.tm.merge(w, times, Integer::sum);
        }

        public List<String> input(char c) {
            if (c == '#') {
                final String key = sb.toString();
                insertWord(key, 1);
                sb.setLength(0);
                curr = root;
                return Collections.emptyList();
            }
            sb.append(c);
            curr = curr == null ? null : curr.children[c == ' ' ? ' ' : c - 'a'];
            if (curr != null) {
                final PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                        (a, b) -> a.getValue().equals(b.getValue())
                                  ? b.getKey().compareTo(a.getKey())
                                  : Integer.compare(a.getValue(), b.getValue()));
                for (Map.Entry<String, Integer> e : curr.tm.entrySet()) {
                    pq.offer(e);
                    if (pq.size() > 3) {
                        pq.poll();
                    }
                }
                final List<String> res = new ArrayList<>();
                while (!pq.isEmpty()) {
                    res.add(0, pq.poll().getKey());
                }
                return res;
            }
            return Collections.emptyList();
        }
    }
}
