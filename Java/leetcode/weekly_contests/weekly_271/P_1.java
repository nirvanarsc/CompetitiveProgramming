package leetcode.weekly_contests.weekly_271;

public class P_1 {

    public int countPoints(String rings) {
        final int n = rings.length();
        final int[] f = new int[10];
        for (int i = 0; i < n; i += 2) {
            final char c = rings.charAt(i);
            final int idx = rings.charAt(i + 1) - '0';
            final int shift;
            if (c == 'R') {
                shift = 0;
            } else if (c == 'B') {
                shift = 1;
            } else {
                shift = 2;
            }
            f[idx] |= 1 << shift;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (f[i] == 7) {
                res++;
            }
        }
        return res;
    }
}
