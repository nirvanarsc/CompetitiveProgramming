package medium;

@SuppressWarnings("unused")
public class P_211 {

    static class WordDictionary {

        static class Trie {
            Trie[] children = new Trie[26];
            boolean isWord;
        }

        Trie root;

        WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie iter = root;
            for (char c : word.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
            iter.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private static boolean dfs(String word, int index, Trie iter) {
            if (iter == null) { return false; }
            if (index == word.length()) { return iter.isWord; }
            boolean res = false;
            if (word.charAt(index) == '.') {
                for (Trie child : iter.children) {
                    res |= dfs(word, index + 1, child);
                }
            } else {
                res = dfs(word, index + 1, iter.children[word.charAt(index) - 'a']);
            }
            return res;
        }
    }
}
