package leetcode.weekly_contests.weekly_50;

import java.util.HashMap;
import java.util.Map;

public class P_677 {

    @SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
    class MapSum {

        class Trie {
            Trie[] children = new Trie[26];
            int sum;
        }

        Trie root;
        Map<String, Integer> prev;

        public MapSum() {
            root = new Trie();
            prev = new HashMap<>();
        }

        public void insert(String key, int val) {
            Trie iter = root;
            final int delta = val - prev.getOrDefault(key, 0);
            prev.put(key, val);
            for (char c : key.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
                iter.sum += delta;
            }
        }

        public int sum(String prefix) {
            Trie iter = root;
            for (char c : prefix.toCharArray()) {
                iter = iter.children[c - 'a'];
                if (iter == null) {
                    return 0;
                }
            }
            return iter.sum;
        }
    }
}

