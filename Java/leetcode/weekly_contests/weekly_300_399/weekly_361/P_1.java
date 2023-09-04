package leetcode.weekly_contests.weekly_300_399.weekly_361;

public class P_1 {

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int num = low; num <= high; num++) {
            res += f(num);
        }
        return res;
    }

    private static int f(int num) {
        final char[] w = String.valueOf(num).toCharArray();
        if (w.length % 2 != 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < w.length; i++) {
            if (i < (w.length / 2)) {
                res += w[i];
            } else {
                res -= w[i];
            }
        }
        return res == 0 ? 1 : 0;
    }
}
