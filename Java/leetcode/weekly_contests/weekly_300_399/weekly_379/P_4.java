package leetcode.weekly_contests.weekly_300_399.weekly_379;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    static char[] w;
    static int n;
    static Map<Long, Integer> dp;

    public int maxPartitionsAfterOperations(String s, int k) {
        w = s.toCharArray();
        n = s.length();
        dp = new HashMap<>();
        return dfs(0, 1, k, w);
    }

    private static int dfs(int idx, int mask, int k, char[] w) {
        if (idx == n) {
            return 1;
        }
        final long key = (long) idx << 27 | mask;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        final int nextMask = mask | (1 << (1 + w[idx] - 'a'));
        final int canChange = mask & 1;
        int res = Integer.bitCount(nextMask >> 1) > k
                  ? 1 + dfs(idx + 1, 1 << (1 + w[idx] - 'a') | canChange, k, w)
                  : dfs(idx + 1, nextMask | canChange, k, w);
        if (canChange == 1) {
            for (int i = 0; i < 26; i++) {
                final int newSet = mask | (1 << (1 + i));
                if (Integer.bitCount(newSet >> 1) > k) {
                    res = Math.max(res, 1 + dfs(idx + 1, 1 << (1 + i), k, w));
                } else {
                    res = Math.max(res, dfs(idx + 1, newSet ^ 1, k, w));
                }
            }
        }
        dp.put(key, res);
        return res;
    }
}
