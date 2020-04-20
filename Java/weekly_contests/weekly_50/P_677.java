package weekly_contests.weekly_50;

import java.util.HashMap;
import java.util.Map;

public class P_677 {

    static class MapSum {
        static class Trie {
            Map<Character, Trie> children = new HashMap<>();
            int value;
        }

        Trie root;
        Map<String, Integer> map;

        MapSum() {
            root = new Trie();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            final int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            Trie cur = root;
            cur.value += delta;
            for (char c : key.toCharArray()) {
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
                cur.value += delta;
            }
        }

        public int sum(String prefix) {
            Trie cur = root;
            for (char c : prefix.toCharArray()) {
                cur = cur.children.get(c);
                if (cur == null) {
                    return 0;
                }
            }
            return cur.value;
        }
    }
}

