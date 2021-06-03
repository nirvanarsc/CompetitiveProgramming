package binarysearch.weekly_34;

public class P_1 {

    public String solve(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        for (int i = 0; i < w.length; i++) {
            if (w[i] == '?') {
                final int l = i == 0 ? -1 : w[i - 1] - '1';
                final int r;
                if (i == (n - 1) || w[i + 1] == '?') {
                    r = -1;
                } else {
                    r = w[i + 1] - '1';
                }
                w[i] = f(l, r);
            }
        }
        return new String(w);
    }

    private static char f(int l, int r) {
        final int[] ok = { 1, 1, 1 };
        if (l != -1) {
            ok[l] = 0;
        }
        if (r != -1) {
            ok[r] = 0;
        }
        for (int i = 0; i < 3; i++) {
            if (ok[i] == 1) {
                return (char) (i + 1 + '0');
            }
        }
        return '*';
    }
}
