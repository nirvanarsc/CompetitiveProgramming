package leetcode.weekly_contests.weekly_62;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_745 {

    class WordFilter {
        private class Trie {
            Trie[] children = new Trie[27];
            int idx = -1;
        }

        Trie root;

        public WordFilter(String[] words) {
            root = new Trie();
            for (int i = 0; i < words.length; i++) {
                for (String p : getCombinations(words[i])) {
                    insert(p, i);
                }
            }
        }

        public int f(String prefix, String suffix) {
            Trie iter = root;
            final String query = prefix + '{' + suffix;
            for (char c : query.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    return -1;
                }
                iter = iter.children[c - 'a'];
            }
            return iter.idx;
        }

        public void insert(String word, int idx) {
            Trie iter = root;
            for (char c : word.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
            iter.idx = Math.max(iter.idx, idx);
        }

        private List<String> getCombinations(String w) {
            final List<String> res = new ArrayList<>();
            for (int i = 0; i < w.length(); i++) {
                final String suffix = w.substring(i);
                for (int j = 1; j <= w.length(); j++) {
                    final String prefix = w.substring(0, j);
                    res.add(prefix + '{' + suffix);
                }
            }
            return res;
        }
    }
}
