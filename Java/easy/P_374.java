package easy;

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
            int lo = 1;
            int hi = n;
            while (lo <= hi) {
                final int mid = lo + hi >>> 1;
                if (guess(mid) == 0) {
                    return mid;
                } else if (guess(mid) < 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }
    }
}
