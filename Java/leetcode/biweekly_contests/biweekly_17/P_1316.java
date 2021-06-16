package leetcode.biweekly_contests.biweekly_17;

import java.util.HashSet;
import java.util.Set;

public class P_1316 {

    public int distinctEchoSubstringsBF(String text) {
        final Set<String> found = new HashSet<>();
        final char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (chars[i] == chars[j]) {
                    if (j + j - i <= text.length()) {
                        final String first = text.substring(i, j);
                        final String second = text.substring(j, j + j - i);
                        if (first.equals(second)) {
                            found.add(first + second);
                        }
                    }
                }
            }
        }

        return found.size();
    }

    private static final int MOD = (int) (1e9 + 7);

    private static final int BASE1 = 69;

    private static final int BASE2 = 6969;

    // RabinKarp
    public int distinctEchoSubstrings(String text) {
        final int n = text.length();
        final char[] w = text.toCharArray();
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
        final Set<Long> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j += 2) {
                final int mid = (i + j) / 2;
                final long h1 = getHash(hash1, pow1, i, mid - 1);
                final long h2 = getHash(hash1, pow1, mid, j - 1);
                final long h3 = getHash(hash2, pow2, i, mid - 1);
                final long h4 = getHash(hash2, pow2, mid, j - 1);
                if (h1 == h2 && h3 == h4) {
                    seen.add(h1);
                }
            }
        }
        return seen.size();
    }

    private static long getHash(long[] hash, long[] pow, int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
    }
}
