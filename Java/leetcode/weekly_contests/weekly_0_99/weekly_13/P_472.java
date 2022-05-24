package leetcode.weekly_contests.weekly_0_99.weekly_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_472 {

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isWord;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Trie root = new Trie();
        for (String w : words) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
            iter.isWord = true;
        }
        final List<String> res = new ArrayList<>();
        for (String w : words) {
            if (dfs(root, w, 0, 0)) {
                res.add(w);
            }
        }
        return res;
    }

    private static boolean dfs(Trie root, String word, int idx, int matched) {
        Trie iter = root;
        for (int i = idx; i < word.length(); i++) {
            iter = iter.children[word.charAt(i) - 'a'];
            if (iter == null) {
                return false;
            }
            if (iter.isWord && dfs(root, word, i + 1, matched + 1)) {
                return true;
            }
        }
        return matched > 1 && idx == word.length();
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
