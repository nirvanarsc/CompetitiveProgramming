package leetcode.weekly_contests.weekly_191;

import java.util.Arrays;

public class P_1465 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long l = 0;
        long r = 0;
        int prev = 0;
        for (int hh : horizontalCuts) {
            l = Math.max(l, hh - prev);
            prev = hh;
        }
        l = Math.max(l, h - prev);
        prev = 0;
        for (int vv : verticalCuts) {
            r = Math.max(r, vv - prev);
            prev = vv;
        }
        r = Math.max(r, w - prev);
        return (int) ((l * r) % MOD);
    }
}
