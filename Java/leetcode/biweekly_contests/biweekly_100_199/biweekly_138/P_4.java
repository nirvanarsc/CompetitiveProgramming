package leetcode.biweekly_contests.biweekly_100_199.biweekly_138;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_4 {

    public long countGoodIntegers(int n, int k) {
        long res = 0;
        final int[] fac = new int[11];
        fac[0] = 1;
        fac[1] = 1;
        for (int i = 2; i < fac.length; i++) {
            fac[i] = i * fac[i - 1];
        }
        for (String p : generatePalindromes(n, k)) {
            res += countValidPermutations(p, fac, n);
        }
        return res;
    }

    public static Set<String> generatePalindromes(int n, int k) {
        final Set<String> result = new HashSet<>();
        final int halfLength = (n + 1) / 2;
        final int start = (n == 1) ? 0 : (int) Math.pow(10, halfLength - 1);
        final int end = (int) Math.pow(10, halfLength);
        for (int i = start; i < end; i++) {
            final String half = Integer.toString(i);
            final String mirrored = mirrorHalf(half, n % 2 != 0);
            final String total = half + mirrored;
            final long ppp = Long.parseLong(total);
            if (ppp % k == 0) {
                final char[] w = total.toCharArray();
                Arrays.sort(w);
                result.add(new String(w));
            }
        }
        return result;
    }

    private static String mirrorHalf(String half, boolean isOddLength) {
        final StringBuilder sb = new StringBuilder(half);
        if (isOddLength) {
            sb.setLength(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    private static long countValidPermutations(String palindrome, int[] fac, int n) {
        final int[] counts = new int[10];
        for (char c : palindrome.toCharArray()) {
            counts[c - '0']++;
        }
        long res = fac[n];
        for (int count : counts) {
            res /= fac[count];
        }
        // Handle leading zeros
        if (counts[0] > 0) {
            counts[0]--;
            long invalid = fac[n - 1];
            for (int count : counts) {
                invalid /= fac[count];
            }
            counts[0]++;
            res -= invalid;
        }
        return res;
    }
}
