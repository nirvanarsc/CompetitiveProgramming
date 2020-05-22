package weekly_contests.weekly_49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
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

    static class MagicDictionaryTrie {

        static class Trie {
            Trie[] children = new Trie[26];
            boolean isWord;
        }

        Trie root;

        MagicDictionaryTrie() {
            root = new Trie();
        }

        public void buildDict(String[] dict) {
            for (String w : dict) {
                Trie iter = root;
                for (char c : w.toCharArray()) {
                    if (iter.children[c - 'a'] == null) {
                        iter.children[c - 'a'] = new Trie();
                    }
                    iter = iter.children[c - 'a'];
                }
                iter.isWord = true;
            }
        }

        public boolean search(String word) {
            return dfs(word, 0, 0, root);
        }

        private static boolean dfs(String w, int pos, int typos, Trie curr) {
            if (w.length() == pos) {
                return typos == 1 && curr.isWord;
            }
            if (typos > 1) {
                return false;
            }
            for (char c = 0; c < 26; c++) {
                if (curr.children[c] == null) {
                    continue;
                }
                final int nextTypos = w.charAt(pos) == c + 'a' ? typos : typos + 1;
                if (dfs(w, pos + 1, nextTypos, curr.children[c])) {
                    return true;
                }
            }
            return false;
        }
    }
}

