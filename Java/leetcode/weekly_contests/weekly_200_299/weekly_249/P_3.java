package leetcode.weekly_contests.weekly_200_299.weekly_249;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    static int[][] dp;
    static int[] good;
    static boolean[][] seen;
    static int size;

    private static final int MOD = (int) (1e9 + 7);

    public int colorTheGrid(int m, int n) {
        dp = new int[n + 1][1 << (2 * m)];
        seen = new boolean[n + 1][1 << (2 * m)];
        size = m;
        final List<Integer> masks = new ArrayList<>();
        for (int mask = 0; mask < (1 << 2 * size); mask++) {
            final int[] curr = parseMask(mask);
            boolean ok = true;
            for (int i = 0; i < size; i++) {
                if (curr[i] == 0) {
                    ok = false;
                    break;
                }
                if (i > 0 && curr[i - 1] == curr[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                masks.add(mask);
            }
        }
        good = masks.stream().mapToInt(Integer::intValue).toArray();
        return dfs(n, 0);
    }

    private static int[] parseMask(int mask) {
        final int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            final int c = mask & 3;
            mask >>= 2;
            res[i] = c;
        }
        return res;
    }

    private static int dfs(int n, int mask) {
        if (n == 0) {
            return 1;
        }
        if (seen[n][mask]) {
            return dp[n][mask];
        }
        int res = 0;
        if (mask == 0) {
            for (int next : good) {
                res = (res + dfs(n - 1, next)) % MOD;
            }
        } else {
            final int[] prev = parseMask(mask);
            for (int next : good) {
                final int[] curr = parseMask(next);
                boolean ok = true;
                for (int i = 0; i < size; i++) {
                    if (prev[i] == curr[i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = (res + dfs(n - 1, next)) % MOD;
                }
            }
        }
        seen[n][mask] = true;
        return dp[n][mask] = res;
    }
}
