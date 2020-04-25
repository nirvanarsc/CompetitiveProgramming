package weekly_contests.weekly_42;

import java.util.List;

public class P_648 {

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        final Trie root = new Trie();
        for (String w : dict) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
            iter.word = w;
        }
        final String[] sent = sentence.split(" ");
        for (int i = 0; i < sent.length; i++) {
            final String dfs = dfs(root, sent[i], 0);
            if (dfs != "") {
                sent[i] = dfs;
            }
        }
        return String.join(" ", sent);
    }

    @SuppressWarnings("TailRecursion")
    private static String dfs(Trie root, String prefix, int i) {
        if (root.word != null) {
            return root.word;
        }
        if (i == prefix.length() || root.children[prefix.charAt(i) - 'a'] == null) {
            return "";
        }
        return dfs(root.children[prefix.charAt(i) - 'a'], prefix, i + 1);
    }
}
