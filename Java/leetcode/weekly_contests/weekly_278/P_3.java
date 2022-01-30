package leetcode.weekly_contests.weekly_278;

public class P_3 {

    static long[] hash;
    static long[] pow;
    static int n;
    static int base;
    static int mod;

    public String subStrHash(String s, int power, int modulo, int k, long hashValue) {
        final char[] w = s.toCharArray();
        n = s.length();
        base = power;
        mod = modulo;
        hash = new long[n + 1];
        pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * base % mod;
            hash[i] = (hash[i - 1] * base + (w[n - i] - 'a' + 1)) % mod;
        }
        for (int i = k; i <= n; i++) {
            if (getHash(n - i, n - i + k - 1) == hashValue) {
                return s.substring(i - k, i);
            }
        }
        return "-1";
    }

    private static long getHash(int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % mod + mod) % mod;
    }
}
