package leetcode.weekly_contests.weekly_200_299.weekly_282;

public class P_3 {

    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0;
        long hi = (long) 1e18;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            long curr = 0;
            for (int t : time) {
                curr += mid / t;
                if (curr > totalTrips) {
                    break;
                }
            }
            if (curr < totalTrips) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
