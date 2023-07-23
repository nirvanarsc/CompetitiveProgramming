package leetcode.biweekly_contests.biweekly_100_199.biweekly_103;

public class P_2 {

    public int[] findThePrefixCommonArray(int[] l, int[] r) {
        long ls = 0L;
        long rs = 0L;
        final int n = l.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            ls |= 1L << l[i];
            rs |= 1L << r[i];
            res[i] = Long.bitCount(ls & rs);
        }
        return res;
    }
}
