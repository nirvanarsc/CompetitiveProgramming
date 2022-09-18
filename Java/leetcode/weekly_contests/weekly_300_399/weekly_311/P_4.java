package leetcode.weekly_contests.weekly_300_399.weekly_311;

public class P_4 {

    static class Trie {
        Trie[] children = new Trie[26];
        int val;
    }

    public int[] sumPrefixScores(String[] words) {
        final int n = words.length;
        final Trie root = new Trie();
        for (String w : words) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
                iter.val++;
            }
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            Trie iter = root;
            for (char c : words[i].toCharArray()) {
                iter = iter.children[c - 'a'];
                curr += iter.val;
            }
            res[i] = curr;
        }
        return res;
    }
}
