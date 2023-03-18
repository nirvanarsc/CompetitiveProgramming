package leetcode.biweekly_contests.biweekly_0_99.biweekly_56;

public class P_1 {

    public int countTriples(int n) {
        final boolean[] sq = new boolean[(int) 2e5];
        for (int i = 1; i <= 250; i++) {
            sq[i * i] = true;
        }
        int res = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                final int curr = (a * a) + (b * b);
                if (sq[curr] && curr <= n * n) {
                    res++;
                }
            }
        }
        return res;
    }
}
