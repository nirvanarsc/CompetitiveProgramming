package leetcode.hard;

public class P_420 {

    public int strongPasswordChecker(String s) {
        int chg = 0, sum = 0, up = 0, low = 0, d = 0;
        final int[] m = new int[3]; // # of SSRC of length 3k, 3k+1, 3k+2
        final int n = s.length();
        for (int i = 0; i < n; ) {
            final char c = s.charAt(i);
            if (Character.isUpperCase(c)) { up = 1; }
            if (Character.isLowerCase(c)) { low = 1; }
            if (Character.isDigit(c)) { d = 1; }
            int r = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                r++;
            }
            if (r >= 3) {
                m[r % 3]++;
                sum += r;
                chg += r / 3;
            }
        }
        final int miss = 3 - up - low - d;
        if (n < 6) {
            return Math.max(miss, 6 - n);
        }
        if (n <= 20) {
            return Math.max(miss, chg);
        }
        final int nDel = n - 20;
        if (nDel <= m[0]) {
            return nDel + Math.max(chg - nDel, miss);
        }
        int rNDel = nDel - m[0];
        chg -= m[0];
        if (rNDel <= 2 * m[1]) {
            return nDel + Math.max(chg - rNDel / 2, miss);
        }
        rNDel -= 2 * m[1];
        chg -= m[1];
        if (nDel <= sum - 2 * (m[0] + m[1] + m[2])) {
            /*
             * This condition is equivalent to nDel-m[0]-2m[1] <= sum{3(k_i-1)} + sum{3(k'_i-1)} + sum{3k''_i},
             * where {3k_i, 1<=i<=m[0]}, {3k'_i+1, 1<=i<=m[1]}, {3k''_i+2, 1<=i<=m[2]} are
             * the sets of lengths of SSRCs
             */
            return nDel + Math.max(chg - rNDel / 3, miss);
        }
        return nDel + miss;
    }
}
