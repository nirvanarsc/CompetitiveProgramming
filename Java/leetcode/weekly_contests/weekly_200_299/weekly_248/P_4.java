package leetcode.weekly_contests.weekly_200_299.weekly_248;

import java.util.HashSet;
import java.util.Set;

public class P_4 {

    private static final long MOD = 1L << 39;

    private static final int BASE = 100003;

    public int longestCommonSubpath(int f, int[][] paths) {
        final int n = paths.length;
        int minL = (int) 1e9;
        for (int[] p : paths) {
            minL = Math.min(minL, p.length);
        }
        final long[] pow = new long[minL + 1];
        pow[0] = 1;
        for (int i = 1; i <= minL; i++) {
            pow[i] = pow[i - 1] * BASE % MOD;
        }
        final long[][] hash = new long[n][];
        for (int i = 0; i < paths.length; i++) {
            final int m = paths[i].length;
            hash[i] = new long[m + 1];
            for (int j = 1; j <= m; j++) {
                hash[i][j] = (hash[i][j - 1] * BASE + (paths[i][j - 1] + 1)) % MOD;
            }
        }
        int lo = 0;
        int hi = minL;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            Set<Long> row = null;
            int ok = 1;
            for (int i = 0; i < paths.length; i++) {
                if (row == null) {
                    row = new HashSet<>();
                    for (int j = 0; j <= paths[i].length - mid; j++) {
                        row.add(getHash(hash[i], pow, j, j + mid - 1));
                    }
                } else {
                    final Set<Long> next = new HashSet<>();
                    for (int j = 0; j <= paths[i].length - mid; j++) {
                        if (row.contains(getHash(hash[i], pow, j, j + mid - 1))) {
                            next.add(getHash(hash[i], pow, j, j + mid - 1));
                        }
                    }
                    row = next;
                    if (row.isEmpty()) {
                        ok = 0;
                        break;
                    }
                }
            }
            if (ok == 1) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static long getHash(long[] hash, long[] pow, int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
    }
}
