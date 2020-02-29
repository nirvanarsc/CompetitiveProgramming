package weekly_contests.weekly_133;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1032 {

    static class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }
    }

    static class StreamChecker {
        Trie root;
        Deque<Trie> queue = new ArrayDeque<>();

        StreamChecker(String[] words) {
            root = buildTrie(words);
            queue.offerLast(root);
        }

        public boolean query(char letter) {
            boolean res = false;
            for (int k = queue.size(); k > 0; k--) {
                final Trie curr = queue.removeFirst();
                if (curr.children[letter - 'a'] != null) {
                    queue.offerLast(curr.children[letter - 'a']);
                    res |= curr.children[letter - 'a'].isWord;
                }
            }
            queue.offerLast(root);
            return res;
        }

        private static Trie buildTrie(String[] words) {
            final Trie root = new Trie();
            for (String w : words) {
                Trie curr = root;
                for (char c : w.toCharArray()) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new Trie();
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.isWord = true;
            }
            return root;
        }
    }

    static class StreamCheckerReverse {
        private final Trie root;
        private final StringBuilder sb;

        StreamCheckerReverse(String[] words) {
            root = new Trie();
            sb = new StringBuilder();

            for (String word : words) {
                insertReversedWordToTrie(word, root);
            }
        }

        private static void insertReversedWordToTrie(String word, Trie root) {
            Trie curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                final char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        public boolean query(char letter) {
            sb.append(letter);
            Trie curr = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                final char c = sb.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
                if (curr.isWord) {
                    return true;
                }
            }
            return false;
        }
    }
}
