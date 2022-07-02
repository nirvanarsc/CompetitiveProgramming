package leetcode.weekly_contests.weekly_100_199.weekly_191;

import java.util.Arrays;

public class P_1465 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long l = 0;
        long r = 0;
        int prev = 0;
        for (int curr : horizontalCuts) {
            l = Math.max(l, curr - prev);
            prev = curr;
        }
        l = Math.max(l, h - prev);
        prev = 0;
        for (int curr : verticalCuts) {
            r = Math.max(r, curr - prev);
            prev = curr;
        }
        r = Math.max(r, w - prev);
        return (int) ((l * r) % MOD);
    }
}
