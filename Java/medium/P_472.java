package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_472 {

    static class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final List<String> res = new ArrayList<>();
        final Trie root = new Trie();
        for (String word : words) {
            if(!word.isEmpty()) {
                Trie curr = root;
                for (char c : word.toCharArray()) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new Trie();
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.isWord = true;
            }
        }
        for (String word : words) {
            if (!word.isEmpty() && checkTrie(root, word.toCharArray(), 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private static boolean checkTrie(Trie root, char[] word, int index, int count) {
        Trie curr = root;
        for (int i = index; i < word.length; i++) {
            if (curr.children[word[i] - 'a'] == null) {
                return false;
            }
            if (curr.children[word[i] - 'a'].isWord) {
                if (i == word.length - 1) {
                    return count > 0;
                }
                if (checkTrie(root, word, i + 1, count + 1)) {
                    return true;
                }
            }
            curr = curr.children[word[i] - 'a'];
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADictDP(String[] words) {
        final List<String> res = new ArrayList<>();
        final Set<String> dict = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (!word.isEmpty()) {
                dict.remove(word);
                if (wordBreak(word, dict)) {
                    res.add(word);
                }
                dict.add(word);
            }
        }
        return res;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
