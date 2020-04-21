package weekly_contests.weekly_49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_676 {

    static class MagicDictionary {
        Set<String> words;
        Map<String, Integer> count;

        MagicDictionary() {
            words = new HashSet<>();
            count = new HashMap<>();
        }

        private static List<String> generalizedNeighbors(String word) {
            final List<String> ans = new ArrayList<>();
            final char[] ca = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                final char letter = ca[i];
                ca[i] = '*';
                final String magic = new String(ca);
                ans.add(magic);
                ca[i] = letter;
            }
            return ans;
        }

        public void buildDict(String[] words) {
            for (String word : words) {
                this.words.add(word);
                for (String nei : generalizedNeighbors(word)) {
                    count.merge(nei, 1, Integer::sum);
                }
            }
        }

        public boolean search(String word) {
            for (String nei : generalizedNeighbors(word)) {
                final int c = count.getOrDefault(nei, 0);
                if (c > 1 || c == 1 && !words.contains(word)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class MagicDictionaryLength {
        Map<Integer, List<String>> map;

        MagicDictionaryLength() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dict) {
            for (String w : dict) {
                map.computeIfAbsent(w.length(), v -> new ArrayList<>()).add(w);
            }
        }

        public boolean search(String word) {
            for (String s : map.getOrDefault(word.length(), Collections.emptyList())) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != s.charAt(i)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}

