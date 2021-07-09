package leetcode.weekly_contests.weekly_56;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
        final int n = Math.min(nums1.length, nums2.length);
        final long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * BASE % MOD;
        }
        final long[][] hash = new long[2][];
        final List<int[]> arr = Arrays.asList(nums1, nums2);
        for (int i = 0; i < arr.size(); i++) {
            final int m = arr.get(i).length;
            hash[i] = new long[m + 1];
            for (int j = 1; j <= m; j++) {
                hash[i][j] = (hash[i][j - 1] * BASE + (arr.get(i)[j - 1] + 1)) % MOD;
            }
        }
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            Set<Long> row = null;
            int ok = 1;
            for (int i = 0; i < arr.size(); i++) {
                if (row == null) {
                    row = new HashSet<>();
                    for (int j = 0; j <= arr.get(i).length - mid; j++) {
                        row.add(getHash(hash[i], pow, j, j + mid - 1));
                    }
                } else {
                    final Set<Long> next = new HashSet<>();
                    for (int j = 0; j <= arr.get(i).length - mid; j++) {
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
