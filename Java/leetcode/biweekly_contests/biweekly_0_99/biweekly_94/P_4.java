package leetcode.biweekly_contests.biweekly_0_99.biweekly_94;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static long[] factorial;
    static long[] facInverse;
    static long[] inverse;

    public int countAnagrams(String s) {
        long res = 1;
        final int MAX = s.length() + 5;
        factorial = new long[MAX];
        facInverse = new long[MAX];
        inverse = new long[MAX];
        factorial[0] = factorial[1] = 1;
        facInverse[0] = facInverse[1] = 1;
        inverse[1] = 1;
        for (int i = 2; i < MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
            final long inv = inverse[i] = MOD - inverse[MOD % i] * (MOD / i) % MOD;
            facInverse[i] = facInverse[i - 1] * inv % MOD;
        }
        for (String w : s.split(" ")) {
            res = (res * f(w)) % MOD;
        }
        return (int) res;
    }

    private static long f(String w) {
        final int[] f = new int[26];
        for (char c : w.toCharArray()) {
            f[c - 'a']++;
        }
        long res = factorial[w.length()];
        for (int i = 0; i < 26; i++) {
            res = (res * facInverse[f[i]]) % MOD;
        }
        return res;
    }
}
