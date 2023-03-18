package leetcode.biweekly_contests.biweekly_0_99.biweekly_27;

public class P_1461 {

    public boolean hasAllCodes(String s, int k) {
        final boolean[] seen = new boolean[1 << k];
        final char[] w = s.toCharArray();
        final int andMask = (1 << k) - 1;
        int need = 1 << k;
        int mask = 0;
        for (int i = 0; i < w.length; i++) {
            mask <<= 1;
            mask |= w[i] - '0';
            if (i >= k - 1) {
                if (!seen[mask & andMask]) {
                    need--;
                    seen[mask & andMask] = true;
                }
            }
        }
        return need == 0;
    }
}
