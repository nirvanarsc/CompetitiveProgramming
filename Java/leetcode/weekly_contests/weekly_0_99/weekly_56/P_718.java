package leetcode.weekly_contests.weekly_0_99.weekly_56;

import java.util.HashSet;
import java.util.Set;

public class P_718 {

    public int findLengthDP(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        final int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res;
    }

    private static final int MOD = (int) (1e9 + 7);

    private static final int BASE = 113;

    public int findLength(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        final int q = Math.min(n, m);
        final long[] pow = new long[q + 1];
        pow[0] = 1;
        for (int i = 1; i <= q; i++) {
            pow[i] = pow[i - 1] * BASE % MOD;
        }
        final long[][] hash = { toHash(nums1), toHash(nums2) };
        int lo = 0;
        int hi = q;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            final Set<Long> seen = new HashSet<>();
            boolean ok = false;
            for (int j = 0; j <= n - mid; j++) {
                seen.add(getHash(hash[0], pow, j, j + mid - 1));
            }
            for (int j = 0; j <= m - mid; j++) {
                if (seen.contains(getHash(hash[1], pow, j, j + mid - 1))) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static long[] toHash(int[] arr) {
        final int m = arr.length;
        final long[] res = new long[m + 1];
        for (int j = 1; j <= m; j++) {
            res[j] = (res[j - 1] * BASE + (arr[j - 1] + 1)) % MOD;
        }
        return res;
    }

    private static long getHash(long[] hash, long[] pow, int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
    }
}
