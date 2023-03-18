package leetcode.biweekly_contests.biweekly_0_99.biweekly_56;

public class P_3 {

    public boolean sumGame(String num) {
        int L = 0;
        int R = 0;
        final int n = num.length();
        final char[] w = num.toCharArray();
        int qL = 0;
        int qR = 0;
        for (int i = 0; i < n / 2; i++) {
            if (w[i] == '?') {
                qL++;
            } else {
                L += w[i] - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (w[i] == '?') {
                qR++;
            } else {
                R += w[i] - '0';
            }
        }
        final int target;
        final int q;
        if (qL > qR) {
            q = qL - qR;
            target = R - L;
        } else {
            q = qR - qL;
            target = L - R;
        }
        if (target < 0) {
            return true;
        }
        final int a = (q + 1) / 2;
        final int b = q / 2;
        return b * 9 < target || target < a * 9;
    }
}
