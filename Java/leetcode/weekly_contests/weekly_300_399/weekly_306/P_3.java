package leetcode.weekly_contests.weekly_300_399.weekly_306;

public class P_3 {

    static String res;

    public String smallestNumber(String pattern) {
        final int n = pattern.length();
        final char[] p = pattern.toCharArray();
        final StringBuilder sb = new StringBuilder();
        //noinspection StringRepeatCanBeUsed
        for (int i = 0; i < n + 1; i++) {
            sb.append(9);
        }
        res = sb.toString();
        char[] w;
        for (int i = 1; i <= 9; i++) {
            w = new char[n + 1];
            w[0] = (char) (i + '0');
            f(w, 1 << i, 0, p);
        }
        return res;
    }

    private static void f(char[] w, int mask, int idx, char[] p) {
        if (idx == p.length) {
            final String u = new String(w);
            if (res.compareTo(u) > 0) {
                res = u;
            }
            return;
        }
        if (p[idx] == 'D') {
            for (int u = 1; u <= 9; u++) {
                if ((mask & (1 << u)) == 0 && w[idx] - '0' > u) {
                    w[idx + 1] = (char) (u + '0');
                    f(w, mask | 1 << u, idx + 1, p);
                }
            }
        } else {
            for (int u = 1; u <= 9; u++) {
                if ((mask & (1 << u)) == 0 && w[idx] - '0' < u) {
                    w[idx + 1] = (char) (u + '0');
                    f(w, mask | 1 << u, idx + 1, p);
                }
            }
        }
    }
}
