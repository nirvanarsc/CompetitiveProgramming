package leetcode.biweekly_contests.biweekly_100_199.biweekly_157;

import java.util.TreeSet;

public class P_2 {

    @SuppressWarnings("unchecked")
    public int maxSubstrings(String word) {
        final char[] w = word.toCharArray();
        final int n = word.length();
        final int[] dp = new int[n + 1];
        final TreeSet<Integer>[] ts = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            ts[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            ts[w[i] - 'a'].add(i);
        }
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            Integer u = ts[w[i] - 'a'].higher(i);
            while (u != null && u - i < 3) {
                u = ts[w[i] - 'a'].higher(u);
            }
            if (u != null) {
                dp[u + 1] = Math.max(dp[u + 1], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
