package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class P_139 {

    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        final Set<String> dict = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean dfs(String s, Set<String> dict, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        boolean res = false;
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && dfs(s, dict, end, dp)) {
                res = true;
                break;
            }
        }
        return dp[start] = res;
    }

    private static class Trie {
        boolean isWord;
        Trie[] children = new Trie[26];
    }

    public boolean wordBreakTrie(String s, List<String> wordDict) {
        final Trie root = new Trie();
        for (String word : wordDict) {
            Trie iter = root;
            for (char c : word.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
            iter.isWord = true;
        }
        return dfs(s.toCharArray(), 0, root, root, new Boolean[s.length()]);
    }

    private static boolean dfs(char[] word, int idx, Trie root, Trie curr, Boolean[] dp) {
        if (idx == word.length) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        boolean res = false;
        for (int i = idx; i < word.length; i++) {
            if (curr.children[word[i] - 'a'] == null) {
                break;
            }
            curr = curr.children[word[i] - 'a'];
            if (curr.isWord) {
                if (dfs(word, i + 1, root, root, dp)) {
                    res = true;
                    break;
                }
            }
        }
        return dp[idx] = res;
    }
}
