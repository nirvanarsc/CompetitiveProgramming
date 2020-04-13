package weekly_contests.weekly_57;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_720 {

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    public String longestWord(String[] words) {
        final Trie root = new Trie();
        for (String w : words) {
            Trie curr = root;
            for (char c : w.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = w;
        }
        String res = "";
        for (String w : words) {
            Trie curr = root;
            boolean found = true;
            for (char c : w.toCharArray()) {
                if (curr.children[c - 'a'].word == null) {
                    found = false;
                    break;
                }
                curr = curr.children[c - 'a'];
            }
            if (found) {
                if (res.length() < curr.word.length()) {
                    res = curr.word;
                } else if (res.length() == curr.word.length() && res.compareTo(curr.word) > 0) {
                    res = curr.word;
                }
            }
        }
        return res;
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

    public String longestWordSet(String[] words) {
        final Set<String> hs = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (String w : words) {
            if (helper(w, hs)) {
                if (w.length() > ans.length()) {
                    ans = w;
                } else if (w.length() == ans.length() && ans.compareTo(w) > 0) {
                    ans = w;
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
