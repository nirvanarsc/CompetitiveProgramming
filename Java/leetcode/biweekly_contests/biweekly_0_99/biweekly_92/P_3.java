package leetcode.biweekly_contests.biweekly_0_99.biweekly_92;

public class P_3 {

    public int bestClosingTime(String customers) {
        final char[] w = customers.toCharArray();
        final int n = w.length;
        final int[] preY = new int[n + 1];
        final int[] preN = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preN[i] = preN[i - 1] + (w[i - 1] == 'N' ? 1 : 0);
            preY[i] = preY[i - 1] + (w[i - 1] == 'Y' ? 1 : 0);
        }
        int res = preY[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            final int c = preN[i] + preY[n] - preY[i];
            if (c < res) {
                res = c;
                idx = i;
            }
        }
        return idx;
    }
}
