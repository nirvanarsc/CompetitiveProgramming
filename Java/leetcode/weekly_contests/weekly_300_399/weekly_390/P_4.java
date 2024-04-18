package leetcode.weekly_contests.weekly_300_399.weekly_390;

public class P_4 {

    private static class Trie {
        int length = (int) 1e9;
        int idx;
        Trie[] children = new Trie[26];
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        final Trie root = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            Trie iter = root;
            final String word = wordsContainer[i];
            final char[] w = word.toCharArray();
            if (iter.length > w.length) {
                iter.length = w.length;
                iter.idx = i;
            }
            for (int j = w.length - 1; j >= 0; j--) {
                if (iter.children[w[j] - 'a'] == null) {
                    iter.children[w[j] - 'a'] = new Trie();
                }
                iter = iter.children[w[j] - 'a'];
                if (iter.length > w.length) {
                    iter.length = w.length;
                    iter.idx = i;
                }
            }
        }
        final int q = wordsQuery.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final char[] w = wordsQuery[i].toCharArray();
            Trie iter = root;
            for (int j = w.length - 1; j >= 0; j--) {
                if (iter.children[w[j] - 'a'] == null) {
                    break;
                }
                iter = iter.children[w[j] - 'a'];
            }
            res[i] = iter.idx;
        }
        return res;
    }
}
