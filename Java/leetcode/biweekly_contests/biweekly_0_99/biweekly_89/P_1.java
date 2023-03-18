package leetcode.biweekly_contests.biweekly_0_99.biweekly_89;

public class P_1 {

    public int countTime(String time) {
        int res = 0;
        final char[] w = time.toCharArray();
        for (int t = 0; t < 1440; t++) {
            final int hh = t / 60;
            final int mm = t % 60;
            if (w[0] != '?' && w[0] - '0' != hh / 10) {
                continue;
            }
            if (w[1] != '?' && w[1] - '0' != hh % 10) {
                continue;
            }
            if (w[3] != '?' && w[3] - '0' != mm / 10) {
                continue;
            }
            if (w[4] != '?' && w[4] - '0' != mm % 10) {
                continue;
            }
            res++;
        }
        return res;
    }
}
