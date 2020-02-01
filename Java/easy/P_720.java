package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P_720 {

    static class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }
    }

    public String longestWord(String[] words) {
        final Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
        int max = 0;
        String ans = "";
        for (String word : words) {
            Trie curr = root;
            boolean complete = true;
            for (char c : word.toCharArray()) {
                if (!curr.children[c - 'a'].isWord) {
                    complete = false;
                    break;
                }
                curr = curr.children[c - 'a'];
            }
            if (complete) {
                if (word.length() > max) {
                    max = word.length();
                    ans = word;
                } else if (word.length() == max) {
                    ans = word.compareTo(ans) > 0 ? ans : word;
                }
            }
        }
        return ans;
    }

    public String longestWordSort(String[] words) {
        Arrays.sort(words);
        final Set<String> built = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }

    public String longestWordTrie(String[] words) {
        final Set<String> hs = new HashSet<>();
        Collections.addAll(hs, words);

        int max = 0;
        String ans = "";
        for (String w : words) {
            if (helper(w, hs)) {
                if (w.length() > max) {
                    max = w.length();
                    ans = w;
                } else if (w.length() == max) {
                    ans = w.compareTo(ans) > 0 ? ans : w;
                }
            }
        }
        return ans;
    }

    public boolean helper(String w, Set<String> hs) {
        for (int i = 1; i < w.length(); i++) {
            final String sub = w.substring(0, i);
            if (!hs.contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
