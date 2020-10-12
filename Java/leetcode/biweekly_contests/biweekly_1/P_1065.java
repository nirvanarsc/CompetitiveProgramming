package leetcode.biweekly_contests.biweekly_1;

import java.util.ArrayList;
import java.util.List;

public class P_1065 {

    public static final int[][] EMPTY = new int[0][];

    static class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }
    }

    public int[][] indexPairs(String text, String[] words) {
        final List<int[]> result = new ArrayList<>();
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
        for (int i = 0; i < text.length(); i++) {
            Trie curr = root;
            if (curr.children[text.charAt(i) - 'a'] != null) {
                int j = i;
                while (j < text.length() && curr.children[text.charAt(j) - 'a'] != null) {
                    curr = curr.children[text.charAt(j) - 'a'];
                    if (curr.isWord) {
                        result.add(new int[] { i, j });
                    }
                    j++;
                }
            }
        }
        return result.toArray(EMPTY);
    }

    public int[][] indexPairsBF(String text, String[] words) {
        final List<int[]> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (String word : words) {
                if (text.startsWith(word, i)) {
                    res.add(new int[] { i, i + word.length() - 1 });
                }
            }
        }
        res.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        return res.toArray(EMPTY);
    }
}
