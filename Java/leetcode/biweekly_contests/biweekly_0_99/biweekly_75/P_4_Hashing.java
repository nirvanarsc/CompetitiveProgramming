package leetcode.biweekly_contests.biweekly_0_99.biweekly_75;

public class P_4_Hashing {

    private static final int MOD = (int) (1e9 + 7);

    private static final int BASE1 = 69;

    private static final int BASE2 = 6969;

    public long sumScores(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final long[] hash1 = new long[n + 1];
        final long[] hash2 = new long[n + 1];
        final long[] pow1 = new long[n + 1];
        final long[] pow2 = new long[n + 1];
        pow1[0] = pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow1[i] = pow1[i - 1] * BASE1 % MOD;
            pow2[i] = pow2[i - 1] * BASE2 % MOD;
            hash1[i] = (hash1[i - 1] * BASE1 + (w[i - 1] - 'a' + 1)) % MOD;
            hash2[i] = (hash2[i - 1] * BASE2 + (w[i - 1] - 'a' + 1)) % MOD;
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int lo = 0;
            int hi = i;
            while (lo < hi) {
                final int mid = (lo + hi + 1) >>> 1;
                if (getHash(hash1, pow1, 0, mid - 1) == getHash(hash1, pow1, n - i, n - i + mid - 1) &&
                    getHash(hash2, pow2, 0, mid - 1) == getHash(hash2, pow2, n - i, n - i + mid - 1)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            res += lo;
        }
        return res;
    }

    private static long getHash(long[] hash, long[] pow, int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
    }
}
