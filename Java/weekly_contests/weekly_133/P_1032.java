package weekly_contests.weekly_133;

import java.util.ArrayDeque;
import java.util.Collections;
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

    static class StreamCheckerAhoCorasick {

        static class Trie {
            Trie fail;
            Trie[] children = new Trie[26];
            char val;
            boolean isWord;

            Trie(char val) {
                this.val = val;
            }
        }

        Trie root = new Trie('0');
        Trie streamNode = root;

        StreamCheckerAhoCorasick(String[] words) {
            buildTrie(words);
            buildFail();
        }

        public boolean query(char letter) {
            Trie firstNode = streamNode.children[letter - 'a'];
            Trie parent = streamNode;
            // 1. Find the matching node
            while (parent.fail != null && firstNode == null) {
                parent = parent.fail;
                firstNode = parent.children[letter - 'a'];
            }
            // 2. Reset streamNode to matching node
            streamNode = firstNode != null ? firstNode : root;
            // 3. Check the matching node isWord attribute and find each fail node the true of isWord attribute
            while (firstNode != null && !firstNode.isWord) {
                firstNode = firstNode.fail;
            }
            return firstNode != null;
        }

        private void buildTrie(String[] words) {
            for (String word : words) {
                Trie current = root;
                for (char c: word.toCharArray()) {
                    if (current.children[c - 'a'] == null) {
                        current.children[c - 'a'] = new Trie(c);
                    }
                    current = current.children[c - 'a'];
                }
                current.isWord = true;
            }
        }

        public void buildFail() {
            // Use BFS to traverse the Trie and build fail pointers.
            final Deque<Trie> queue = new ArrayDeque<>(Collections.singleton(root));
            while (!queue.isEmpty()) {
                final Trie parent = queue.removeFirst();
                for (Trie child : parent.children) {
                    if (child != null) {
                        Trie fail = parent.fail;
                        while (fail != null) {
                            final Trie failChild = fail.children[child.val - 'a'];
                            if (failChild != null) {
                                child.fail = failChild;
                                break;
                            }
                            fail = fail.fail;
                        }
                        if (child.fail == null) {
                            child.fail = root;
                        }
                        queue.offerLast(child);
                    }
                }
            }
        }
    }
}
