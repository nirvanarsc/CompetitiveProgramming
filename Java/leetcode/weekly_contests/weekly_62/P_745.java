package leetcode.weekly_contests.weekly_62;

public class P_745 {

    static class WordFilter {
        static class Trie {
            Trie[] children = new Trie[27];
            Integer weight;
        }

        Trie root;

        WordFilter(String[] words) {
            root = new Trie();
            for (int weight = 0; weight < words.length; weight++) {
                final String word = words[weight] + '{';
                for (int i = 0; i < word.length(); i++) {
                    Trie cur = root;
                    cur.weight = weight;
                    for (int j = i; j < 2 * word.length() - 1; j++) {
                        final int k = word.charAt(j % word.length()) - 'a';
                        if (cur.children[k] == null) {
                            cur.children[k] = new Trie();
                        }
                        cur = cur.children[k];
                        cur.weight = weight;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            final String w = suffix + '{' + prefix;
            Trie node = root;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return -1;
                }
                node = node.children[c - 'a'];
            }
            return node.weight;
        }
    }
}
