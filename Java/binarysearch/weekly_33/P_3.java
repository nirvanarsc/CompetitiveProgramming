package binarysearch.weekly_33;

public class P_3 {

    private static final int HASH = 3137;
    private static final int MOD = (int) (1e9 + 7);
    long[] pow = new long[(int) (2e4 + 5)];
    long[] hash = new long[(int) (2e4 + 5)];
    boolean init;

    private void init() {
        if (init) {
            return;
        }
        init = true;
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * HASH) % MOD;
        }
    }

    // RabinKarp
    private long getHash(int lhs, int rhs) {
        // returns hash of substring [lhs, rhs)
        long val = hash[rhs] - hash[lhs] * pow[rhs - lhs];
        val %= MOD;
        if (val < 0) {
            val += MOD;
        }
        return val;
    }

    private boolean match(int s1, int s2, int len) {
        return getHash(s1, s1 + len) == getHash(s2, s2 + len);
    }

    public int solve(String s) {
        init();
        final int n = s.length();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < 2 * n; i++) {
            hash[i + 1] = (hash[i] * HASH + chars[i % n]) % MOD;
        }
        int res = (n - 1) * (n - 2) / 2;
        if (n % 3 == 0) {
            final int len = n / 3;
            if (match(0, len, 2 * len)) {
                res--;
            } else if (match(len, 2 * len, 2 * len)) {
                res--;
            }
        }
        for (int len = 1; 2 * len < n; len++) {
            if (3 * len == n) {
                continue;
            }
            final int other = n - 2 * len;
            // b+c == c+a?
            if (match(len, 2 * len, len + other)) { res--; }
            // a+b == b+c?
            if (match(0, len, len + other)) { res--; }
            // c+a == a+b?
            if (match(0, len + other, len + other)) { res--; }
        }
        return res;
    }
}
