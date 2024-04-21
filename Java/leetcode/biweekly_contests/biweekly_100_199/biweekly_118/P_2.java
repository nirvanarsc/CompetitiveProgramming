package leetcode.biweekly_contests.biweekly_100_199.biweekly_118;

import java.util.Arrays;

public class P_2 {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        final int u = Math.min(f(hBars), f(vBars));
        return u * u;
    }

    private static int f(int[] bars) {
        final int n = bars.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && bars[j - 1] + 1 == bars[j]) {
                j++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
