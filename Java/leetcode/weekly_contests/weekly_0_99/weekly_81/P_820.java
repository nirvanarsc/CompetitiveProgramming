package leetcode.weekly_contests.weekly_0_99.weekly_81;

public class P_820 {

    static class Trie {
        Trie[] children = new Trie[26];
        int length;
    }

    public int minimumLengthEncoding(String[] words) {
        final Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;
            final int n = word.length();
            for (int i = n - 1; i >= 0; i--) {
                final char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
            }
            curr.length = n;
        }
        return dfs(root);
    }

    private static int dfs(Trie root) {
        int res = 0;
        boolean hasChildren = false;
        for (Trie c : root.children) {
            if (c != null) {
                hasChildren = true;
                res += dfs(c);
            }
        }
        if (!hasChildren) {
            res += root.length + 1;
        }
        return res;
    }
}
