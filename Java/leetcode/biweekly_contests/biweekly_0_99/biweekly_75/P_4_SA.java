package leetcode.biweekly_contests.biweekly_0_99.biweekly_75;

import java.util.Arrays;

public class P_4_SA {

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     */
    public static class Suffix implements Comparable<Suffix> {
        int index;
        int[] rank = new int[2];

        @Override
        public int compareTo(Suffix other) {
            return rank[0] == other.rank[0] ? Integer.compare(rank[1], other.rank[1])
                                            : Integer.compare(rank[0], other.rank[0]);
        }
    }

    private static int[] buildSuffixArray(String s, int n) {
        final Suffix[] sa = new Suffix[n];
        for (int i = 0; i < n; i++) {
            sa[i] = new Suffix();
            sa[i].index = i;
            sa[i].rank[0] = s.charAt(i) - 'a';
            sa[i].rank[1] = i < n - 1 ? s.charAt(i + 1) - 'a' : -1;
        }
        Arrays.sort(sa);
        final int[] ind = new int[n];
        for (int k = 4; k < 2 * n; k *= 2) {
            int rank = 0;
            int prev_rank = sa[0].rank[0];
            sa[0].rank[0] = rank;
            ind[sa[0].index] = 0;
            for (int i = 1; i < n; i++) {
                if (sa[i].rank[0] == prev_rank && sa[i].rank[1] == sa[i - 1].rank[1]) {
                    prev_rank = sa[i].rank[0];
                    sa[i].rank[0] = rank;
                } else {
                    prev_rank = sa[i].rank[0];
                    sa[i].rank[0] = ++rank;
                }
                ind[sa[i].index] = i;
            }
            for (int i = 0; i < n; i++) {
                final int nextindex = sa[i].index + k / 2;
                sa[i].rank[1] = (nextindex < n) ? sa[ind[nextindex]].rank[0] : -1;
            }
            Arrays.sort(sa);
        }
        final int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = sa[i].index;
        }
        return ret;
    }

    static int[] kasai(String s, int[] suffixArr) {
        final int n = suffixArr.length;
        final int[] lcp = new int[n];
        final int[] invSuff = new int[n];
        for (int i = 0; i < n; i++) {
            invSuff[suffixArr[i]] = i;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (invSuff[i] == n - 1) {
                k = 0;
                continue;
            }
            final int j = suffixArr[invSuff[i] + 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[invSuff[i]] = k;
            if (k > 0) { k--; }
        }
        return lcp;
    }

    public long sumScores(String s) {
        final int[] suffixArr = buildSuffixArray(s, s.length());
        final int[] lcp = kasai(s, suffixArr);
        final int n = s.length();
        final int[] invSuff = new int[n];
        for (int i = 0; i < n; i++) {
            invSuff[suffixArr[i]] = i;
        }
        final int m = invSuff[0];
        int v = n;
        long res = 0;
        for (int i = m - 1; i >= 0; i--) {
            res += v;
            v = Math.min(v, lcp[i]);
        }
        res += v;
        v = n;
        for (int i = m; i < n; i++) {
            v = Math.min(v, lcp[i]);
            res += v;
        }
        return res;
    }
}
