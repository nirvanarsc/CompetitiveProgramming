package leetcode.medium;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_208 {

    class Trie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode iter = root;
            for (char c : word.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new TrieNode();
                }
                iter = iter.children[c - 'a'];
            }
            iter.isWord = true;
        }

        public boolean search(String word) {
            TrieNode iter = root;
            for (char c : word.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    return false;
                }
                iter = iter.children[c - 'a'];
            }
            return iter.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode iter = root;
            for (char c : prefix.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    return false;
                }
                iter = iter.children[c - 'a'];
            }
            return true;
        }
    }
}

