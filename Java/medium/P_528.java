package medium;

import java.util.Random;

@SuppressWarnings("unused")
public class P_528 {

    static class Solution {
        int[] sum;
        Random r;

        Solution(int[] w) {
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            sum = w;
            r = new Random();
        }

        public int pickIndex() {
            return lowerBound(r.nextInt(sum[sum.length - 1]) + 1);
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
