package weekly_contests.weekly_191;

import java.util.Arrays;

public class P_1465 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = h - horizontalCuts[horizontalCuts.length - 1];
        long maxW = w - verticalCuts[verticalCuts.length - 1];
        int prevCut = 0;
        for (int hCut : horizontalCuts) {
            maxH = Math.max(maxH, hCut - prevCut);
            prevCut = hCut;
        }
        prevCut = 0;
        for (int vCut : verticalCuts) {
            maxW = Math.max(maxW, vCut - prevCut);
            prevCut = vCut;
        }
        return Math.floorMod(maxH * maxW, MOD);
    }
}
