package leetcode.weekly_contests.weekly_200_299.weekly_242;

import java.util.Arrays;
import java.util.TreeSet;

public class P_1871 {

    static TreeSet<Integer> ts;
    static int[] dp;

    public boolean canReach(String s, int minJump, int maxJump) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        if (w[n - 1] == '1') {
            return false;
        }
        ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (w[i] == '0') {
                ts.add(i);
            }
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(w, 0, n, minJump, maxJump) == 1;
    }

    private static int dfs(char[] w, int idx, int n, int min, int max) {
        if (idx == n - 1) {
            return 1;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int res = 0;
        final Integer next1 = ts.ceiling(Math.min(n - 1, idx + min));
        final Integer next2 = ts.floor(Math.min(n - 1, idx + max));
        if (next1 != null && idx + min <= next1 && next1 <= (idx + max)) {
            res |= dfs(w, next1, n, min, max);
        }
        if (next2 != null && next1 != null && next2 > next1) {
            res |= dfs(w, next2, n, min, max);
        }
        return dp[idx] = res;
    }

    // sliding window dp
    public boolean canReachSW(String s, int minJump, int maxJump) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0;
        for (int i = minJump; i < n; i++) {
            count += dp[i - minJump] ? 1 : 0;
            dp[i] = w[i] == '0' && count > 0;
            if (i >= maxJump) {
                count -= dp[i - maxJump] ? 1 : 0;
            }
        }
        return dp[n - 1];
    }
}
