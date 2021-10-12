package leetcode.easy;

public class P_374 {

    private static int guess(int n) {
        return (int) (n * Math.random());
    }

    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (guess(mid) > 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
