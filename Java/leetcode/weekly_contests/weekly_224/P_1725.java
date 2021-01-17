package leetcode.weekly_contests.weekly_224;

public class P_1725 {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        for (int[] r : rectangles) {
            maxLen = Math.max(maxLen, Math.min(r[0], r[1]));
        }
        int res = 0;
        for (int[] r : rectangles) {
            final int curr = Math.min(r[0], r[1]);
            if (curr == maxLen) {
                res++;
            }
        }
        return res;
    }
}
