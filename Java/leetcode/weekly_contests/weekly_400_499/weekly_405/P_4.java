package leetcode.weekly_contests.weekly_400_499.weekly_405;

import java.util.Arrays;

public class P_4 {

    static class Trie {
        Trie[] c = new Trie[26];
        int cost = (int) 1e9;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        final Trie root = new Trie();
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            add(root, words[i], costs[i]);
        }
        n = target.length();
        final int[] dp = new int[n + 1];
        final char[] w = target.toCharArray();
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            Trie iter = root;
            int j = i;
            while (j < n && iter.c[w[j] - 'a'] != null) {
                iter = iter.c[w[j++] - 'a'];
                dp[j] = Math.min(dp[j], dp[i] + iter.cost);
            }
        }
        return dp[n] == (int) 1e9 ? -1 : dp[n];
    }

    private static void add(Trie root, String w, int cost) {
        Trie iter = root;
        for (char c : w.toCharArray()) {
            if (iter.c[c - 'a'] == null) {
                iter.c[c - 'a'] = new Trie();
            }
            iter = iter.c[c - 'a'];
        }
        iter.cost = Math.min(iter.cost, cost);
    }
}
