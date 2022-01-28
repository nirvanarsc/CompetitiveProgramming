package leetcode.medium;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_211 {

    class WordDictionary {

        class Trie {
            Trie[] children = new Trie[26];
            boolean isWord;
        }

        Trie root;

        public WordDictionary() {
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
            return dfs(word.toCharArray(), 0, root);
        }

        private boolean dfs(char[] w, int idx, Trie iter) {
            if (iter == null) { return false; }
            if (idx == w.length) { return iter.isWord; }
            if (w[idx] == '.') {
                for (Trie child : iter.children) {
                    if (dfs(w, idx + 1, child)) {
                        return true;
                    }
                }
                return false;
            }
            //noinspection TailRecursion
            return dfs(w, idx + 1, iter.children[w[idx] - 'a']);
        }
    }
}
