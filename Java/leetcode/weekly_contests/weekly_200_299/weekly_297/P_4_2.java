package leetcode.weekly_contests.weekly_200_299.weekly_297;

import java.util.HashSet;
import java.util.Set;

public class P_4_2 {

    public long distinctNames(String[] ideas) {
        final Set<Long> set = new HashSet<>();
        final int[] f = new int[26];
        final int[][] g = new int[26][26];
        for (String w : ideas) {
            set.add(hash(w));
            f[w.charAt(0) - 'a']++;
        }
        final long[] p = new long[10];
        p[0] = 1;
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] * 26;
        }
        for (String w : ideas) {
            final long curr = hash(w);
            for (char c = 'a'; c <= 'z'; c++) {
                if (set.contains(curr + (c - w.charAt(0)) * p[w.length() - 1])) {
                    g[c - 'a'][w.charAt(0) - 'a']++;
                }
            }
        }
        long res = 0;
        for (String w : ideas) {
            int valid = 0;
            final long curr = hash(w);
            for (char c = 'a'; c <= 'z'; c++) {
                if (!set.contains(curr + (c - w.charAt(0)) * p[w.length() - 1])) {
                    valid += f[c - 'a'] - g[w.charAt(0) - 'a'][c - 'a'];
                }
            }
            res += valid;
        }
        return res;
    }

    private static long hash(String w) {
        final int n = w.length();
        final char[] z = w.toCharArray();
        long p = 1;
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += p * (z[i] - 'a' + 1);
            p *= 26;
        }
        return res;
    }
}
