package leetcode.easy;

import java.util.Random;

public class P_374 {

    static class GuessGame {
        int i = new Random().nextInt(Integer.MAX_VALUE);

        int guess(int num) {
            return Integer.compare(num, i);
        }
    }

    public static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int lo = 1, hi = n;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (guess(mid) == 1) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
