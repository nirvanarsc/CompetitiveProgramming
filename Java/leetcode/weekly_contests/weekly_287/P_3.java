package leetcode.weekly_contests.weekly_287;

public class P_3 {

    public int maximumCandies(int[] candies, long k) {
        long lo = 0;
        long hi = (long) 1e12;
        while (lo < hi) {
            final long mid = (lo + hi + 1) >>> 1;
            long curr = 0;
            for (int c : candies) {
                curr += c / mid;
            }
            if (curr >= k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int) lo;
    }
}
