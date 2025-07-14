package leetcode.weekly_contests.weekly_400_499.weekly_458;

public class P_3 {

    public char processStr(String s, long k) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final long[] lengths = new long[n + 1];
        long curr = 0;
        for (int i = 0; i < n; i++) {
            final char op = w[i];
            if (Character.isLowerCase(op)) {
                curr++;
            } else if (op == '*') {
                curr = Math.max(0, curr - 1);
            } else if (op == '#') {
                curr <<= 1;
            }
            lengths[i + 1] = curr;
        }
        if (k >= curr) {
            return '.';
        }
        for (int i = n - 1; i >= 0; i--) {
            final char op = w[i];
            final long lengthAfterOp = lengths[i + 1];
            final long lengthBeforeOp = lengths[i];
            if (op == '#') {
                k %= lengthBeforeOp;
            } else if (op == '%') {
                k = lengthAfterOp - 1 - k;
            } else if (Character.isLowerCase(op)) {
                if (k == lengthBeforeOp) {
                    return op;
                }
            }
        }
        return '.';
    }
}
