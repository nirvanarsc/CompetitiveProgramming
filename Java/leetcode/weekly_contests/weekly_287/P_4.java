package leetcode.weekly_contests.weekly_287;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class Encrypter {

        class Trie {
            Trie[] c = new Trie[26];
            boolean isWord;
        }

        Trie root;
        String[] d = new String[26];
        Map<String, List<Integer>> map = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                d[keys[i] - 'a'] = values[i];
                map.computeIfAbsent(values[i], val -> new ArrayList<>()).add(keys[i] - 'a');
            }
            root = new Trie();
            for (String w : dictionary) {
                Trie iter = root;
                for (char c : w.toCharArray()) {
                    if (iter.c[c - 'a'] == null) {
                        iter.c[c - 'a'] = new Trie();
                    }
                    iter = iter.c[c - 'a'];
                }
                iter.isWord = true;
            }
        }

        public String encrypt(String word1) {
            final StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                sb.append(d[c - 'a']);
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            return dfs(root, word2, 0);
        }

        private int dfs(Trie node, String word, int idx) {
            if (node == null) {
                return 0;
            }
            if (idx == word.length()) {
                return node.isWord ? 1 : 0;
            }
            int res = 0;
            for (int u : map.getOrDefault(word.substring(idx, idx + 2), Collections.emptyList())) {
                res += dfs(node.c[u], word, idx + 2);
            }
            return res;
        }
    }
}
