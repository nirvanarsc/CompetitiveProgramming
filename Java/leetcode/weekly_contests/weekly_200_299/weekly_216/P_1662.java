package leetcode.weekly_contests.weekly_200_299.weekly_216;

public class P_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        final int n = word1.length;
        final int m = word2.length;
        final int[] l = new int[2];
        final int[] r = new int[2];
        final char[] ll = new char[1000];
        final char[] rr = new char[1000];
        int wl = 1000;
        int wr = 1000;
        while (wl == wr && wl != 0) {
            wl = fillBuffer(word1, ll, l);
            wr = fillBuffer(word2, rr, r);
            for (int k = 0; k < Math.min(wl, wr); k++) {
                if (ll[k] != rr[k]) {
                    return false;
                }
            }
        }
        return wl == wr && l[0] == n && r[0] == m;
    }

    private static int fillBuffer(String[] w, char[] buf, int[] idx) {
        int res = 0;
        for (int i = 0; i < buf.length && idx[0] < w.length; i++) {
            if (idx[1] == w[idx[0]].length()) {
                idx[0]++;
                idx[1] = 0;
            }
            if (idx[0] == w.length) {
                break;
            }
            buf[i] = w[idx[0]].charAt(idx[1]++);
            res++;
        }
        return res;
    }
}
