package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_336 {

    static class Trie {
        Trie[] children = new Trie[26];
        List<Integer> palindromes = new ArrayList<>();
        Integer idx;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        final List<List<Integer>> res = new ArrayList<>();
        final Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            Trie iter = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                if (isPalindrome(words[i], 0, j)) {
                    iter.palindromes.add(i);
                }
                if (iter.children[words[i].charAt(j) - 'a'] == null) {
                    iter.children[words[i].charAt(j) - 'a'] = new Trie();
                }
                iter = iter.children[words[i].charAt(j) - 'a'];
            }
            iter.palindromes.add(i);
            iter.idx = i;
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, res);
        }
        return res;
    }

    private static void search(Trie curr, String word, int start, List<List<Integer>> res) {
        for (int j = 0; j < word.length(); j++) {
            if (curr.idx != null && curr.idx != start && isPalindrome(word, j, word.length() - 1)) {
                res.add(Arrays.asList(start, curr.idx));
            }
            curr = curr.children[word.charAt(j) - 'a'];
            if (curr == null) {
                return;
            }
        }
        for (int j : curr.palindromes) {
            if (j != start) {
                res.add(Arrays.asList(start, j));
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
