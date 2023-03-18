package leetcode.biweekly_contests.biweekly_0_99.biweekly_91;

public class P_4 {

    public String[] splitMessage(String message, int limit) {
        final int n = message.length();
        int cum = 0;
        for (int d = 1; d <= n; d++) {
            final int len = l(d) + 3;
            if (len + l(d) > limit) { break; }
            cum += l(d);
            final long all = cum + (long) len * d + n;
            if (all <= (long) limit * d) {
                final String[] ret = new String[d];
                int p = 0;
                for (int j = 0; j < d; j++) {
                    final String suf = "<" + (j + 1) + '/' + d + '>';
                    final int rem = limit - suf.length();
                    final int to = Math.min(p + rem, n);
                    ret[j] = message.substring(p, to) + suf;
                    p = to;
                }
                return ret;
            }
        }
        //noinspection ZeroLengthArrayAllocation
        return new String[0];
    }

    private static int l(int n) {
        if (n < 10) { return 1; }
        if (n < 100) { return 2; }
        if (n < 1000) { return 3; }
        return 4;
    }
}
