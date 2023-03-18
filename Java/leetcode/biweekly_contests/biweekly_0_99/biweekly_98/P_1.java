package leetcode.biweekly_contests.biweekly_0_99.biweekly_98;

public class P_1 {

    public int minMaxDifference(int num) {
        final String n = String.valueOf(num);
        int res = 0;
        for (char l = '0'; l <= '9'; l++) {
            for (char r = '0'; r <= '9'; r++) {
                final int u = Integer.parseInt(n.replace(l, '9'));
                final int v = Integer.parseInt(n.replace(r, '0'));
                res = Math.max(res, u - v);
            }
        }
        return res;
    }
}
