package weekly_164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1268 {

    static class Trie {
        Trie[] child;
        List<String> suggestions;

        Trie() {
            child = new Trie[26];
            suggestions = new ArrayList<>();
        }
    }

    public List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        final List<List<String>> res = new ArrayList<>();
        Trie root = new Trie();
        Arrays.sort(products);

        for (String product : products) {
            Trie t = root;
            for (char c : product.toCharArray()) {
                if (t.child[c - 'a'] == null) {
                    t.child[c - 'a'] = new Trie();
                }
                t = t.child[c - 'a'];
                if (t.suggestions.size() < 3) {
                    t.suggestions.add(product);
                }
            }
        }

        for (char c : searchWord.toCharArray()) {
            if (root != null && root.child[c - 'a'] != null) {
                res.add(root.child[c - 'a'].suggestions);
            } else {
                res.add(new ArrayList<>());
            }
            if (root != null) {
                root = root.child[c - 'a'];
            }
        }
        return res;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
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
