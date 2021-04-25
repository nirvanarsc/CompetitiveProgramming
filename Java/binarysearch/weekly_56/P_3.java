package binarysearch.weekly_56;

public class P_3 {

    private static class Trie {
        Trie[] children = new Trie[26];
        boolean isWord;
    }

    static int res;

    public int solve(String[] words) {
        final Trie root = new Trie();
        for (String word : words) {
            Trie iter = root;
            for (char letter : word.toCharArray()) {
                if (iter.children[letter - 'a'] == null) {
                    iter.children[letter - 'a'] = new Trie();
                }
                iter = iter.children[letter - 'a'];
            }
            iter.isWord = true;
        }
        res = 0;
        dfs(root, 0);
        return res;
    }

    private static void dfs(Trie curr, int path) {
        res = Math.max(res, path);
        if (curr == null) {
            return;
        }
        for (Trie child : curr.children) {
            dfs(child, curr.isWord ? path + 1 : 0);
        }
    }
}
