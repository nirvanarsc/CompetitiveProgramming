package leetcode.weekly_contests.weekly_164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1268 {

    static class Trie {
        Trie[] children = new Trie[26];
        List<String> list = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        final Trie root = new Trie();
        for (String w : products) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
                if (iter.list.size() < 3) {
                    iter.list.add(w);
                }
            }
        }
        final List<List<String>> res = new ArrayList<>();
        dfs(root, searchWord, 0, res);
        return res;
    }

    private static void dfs(Trie trie, String word, int idx, List<List<String>> res) {
        if (trie == null) {
            res.add(new ArrayList<>());
        } else if (idx > 0) {
            res.add(trie.list);
        }
        if (idx == word.length()) {
            return;
        }
        dfs(trie == null ? null : trie.children[word.charAt(idx) - 'a'], word, idx + 1, res);
    }

    public List<List<String>> suggestedProductsBS(String[] products, String searchWord) {
        final List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            final String curr = searchWord.substring(0, i);
            int k = Arrays.binarySearch(products, curr);
            while (k > 0 && curr.equals(products[k - 1])) {
                --k;
            }
            if (k < 0) {
                k = ~k;
            }
            final List<String> suggestion = new ArrayList<>();
            for (final int j = k + 3; k < products.length && k < j && products[k].startsWith(curr); k++) {
                suggestion.add(products[k]);
            }
            ans.add(suggestion);
        }
        return ans;
    }
}
