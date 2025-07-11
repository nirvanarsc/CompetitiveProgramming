package leetcode.biweekly_contests.biweekly_100_199.biweekly_142;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int possibleStringCount(String word, int k) {
        final char[] w = word.toCharArray();
        final List<Integer> g = new ArrayList<>();
        final int n = w.length;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            g.add(j - i);
            i = j;
        }
        final int m = g.size();
        long res = 1;
        for (int len : g) {
            res = (res * len) % MOD;
        }
        if (!(m < k)) {
            return (int) res;
        }
        long[] dp = new long[k];
        dp[0] = 1;
        for (int u : g) {
            final long[] next = new long[k];
            for (int i = 0; i < k - 1; i++) {
                // add() to range [1, u] for every possible offset of i
                final int l = i + 1;
                final int r = i + u + 1;
                next[l] = (next[l] + dp[i]) % MOD;
                if (r < k) {
                    next[r] = (next[r] - dp[i] + MOD) % MOD;
                }
            }
            // apply() the updates
            long curr = next[0];
            for (int i = 1; i < k; i++) {
                curr = (curr + next[i]) % MOD;
                next[i] = curr;
            }
            dp = next;
        }
        // subtract the bad results (length < k)
        for (int i = 0; i < k; i++) {
            res = (res - dp[i] + MOD) % MOD;
        }
        return (int) res;
    }
}
