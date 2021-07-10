package leetcode.weekly_contests.weekly_40;

import java.util.Arrays;

public class P_639 {

    static final int[][] map = new int[58][58];

    static {
        Arrays.fill(map['*'], 1);
        map['*']['*'] = 15;
        map['*']['0'] = 2;
        map['*']['1'] = 2;
        map['*']['2'] = 2;
        map['*']['3'] = 2;
        map['*']['4'] = 2;
        map['*']['5'] = 2;
        map['*']['6'] = 2;
        Arrays.fill(map['1'], 1);
        map['1']['*'] = 9;
        Arrays.fill(map['2'], 1);
        map['2']['*'] = 6;
        map['2']['7'] = 0;
        map['2']['8'] = 0;
        map['2']['9'] = 0;
        Arrays.fill(map[0], 1);
        map[0]['*'] = 9;
        map[0]['0'] = 0;
    }

    public int numDecodingsBottomUp(String s) {
        long cur = map[0][s.charAt(0)], pre = 1;
        for (int i = 1; i < s.length(); i++) {
            final char newC = s.charAt(i);
            final char oldC = s.charAt(i - 1);
            final long next = (map[0][newC] * cur + map[oldC][newC] * pre) % MOD;
            pre = cur;
            cur = next;
        }
        return (int) cur;
    }

    private static final int MOD = (int) (1e9 + 7);

    static long[] dp;
    static boolean[] seen;

    public int numDecodings(String s) {
        final int n = s.length();
        dp = new long[n];
        seen = new boolean[n];
        return (int) (dfs(s.toCharArray(), 0) % MOD);
    }

    private static long dfs(char[] w, int idx) {
        if (idx == w.length) {
            return 1;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        long res = 0;
        if (idx < w.length - 1) {
            if (w[idx + 1] == '*') {
                if (w[idx] == '1') {
                    res = (res + 9 * dfs(w, idx + 2)) % MOD;
                } else if (w[idx] == '2') {
                    res = (res + 6 * dfs(w, idx + 2)) % MOD;
                } else if (w[idx] == '*') {
                    res = (res + 15 * dfs(w, idx + 2)) % MOD;
                }
            } else {
                if (w[idx] == '1') {
                    res = (res + dfs(w, idx + 2)) % MOD;
                } else if (w[idx] == '2' && w[idx + 1] <= '6') {
                    res = (res + dfs(w, idx + 2)) % MOD;
                } else if (w[idx] == '*' && w[idx + 1] <= '6') {
                    res = (res + 2 * dfs(w, idx + 2)) % MOD;
                } else if (w[idx] == '*') {
                    res = (res + dfs(w, idx + 2)) % MOD;
                }
            }
        }
        if (w[idx] == '*') {
            res = (res + 9 * dfs(w, idx + 1)) % MOD;
        } else if (w[idx] != '0') {
            res = (res + dfs(w, idx + 1)) % MOD;
        }
        seen[idx] = true;
        return dp[idx] = res;
    }
}
