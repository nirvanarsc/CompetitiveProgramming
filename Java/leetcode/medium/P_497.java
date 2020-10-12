package leetcode.medium;

import java.util.Random;

@SuppressWarnings("unused")
public class P_497 {

    static class Solution {

        int[][] rects;
        int[] sum;
        Random r;

        Solution(int[][] rects) {
            this.rects = rects;
            sum = new int[rects.length];
            r = new Random();
            for (int i = 0; i < rects.length; i++) {
                final int xd = rects[i][2] - rects[i][0] + 1;
                final int yd = rects[i][3] - rects[i][1] + 1;
                sum[i] = (xd * yd) + (i > 0 ? sum[i - 1] : 0);
            }
        }

        public int[] pick() {
            int target = r.nextInt(sum[sum.length - 1]);
            final int idx = lowerBound(target + 1);
            target -= idx > 0 ? sum[idx - 1] : 0;
            final int yd = rects[idx][3] - rects[idx][1] + 1;
            final int x = target / yd;
            final int y = target % yd;
            return new int[] { rects[idx][0] + x, rects[idx][1] + y };
        }

        private int lowerBound(int target) {
            int lo = 0, hi = sum.length;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (sum[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
