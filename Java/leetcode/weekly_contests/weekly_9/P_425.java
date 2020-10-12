package leetcode.weekly_contests.weekly_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_425 {

    static class Trie {
        Trie[] children = new Trie[26];
        List<String> words = new ArrayList<>();
    }

    public List<List<String>> wordSquares(String[] words) {
        final Trie root = new Trie();
        root.words.addAll(Arrays.asList(words));
        for (String w : words) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
                iter.words.add(w);
            }
        }
        final List<List<String>> res = new ArrayList<>();
        final int n = words[0].length();
        dfs(root, new ArrayList<>(), res, n);
        return res;
    }

    private static void dfs(Trie root, List<String> curr, List<List<String>> res, int n) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        final StringBuilder sb = new StringBuilder();
        final int size = curr.size();
        for (int i = 0; i < size; i++) {
            sb.append(curr.get(i).charAt(size));
        }
        Trie iter = root;
        boolean hasPrefix = true;
        for (char c : sb.toString().toCharArray()) {
            if (iter.children[c - 'a'] == null) {
                hasPrefix = false;
                break;
            }
            iter = iter.children[c - 'a'];
        }
        final List<String> next = hasPrefix ? iter.words : Collections.emptyList();
        for (String word : next) {
            curr.add(word);
            dfs(root, curr, res, n);
            curr.remove(curr.size() - 1);
        }
    }
}
