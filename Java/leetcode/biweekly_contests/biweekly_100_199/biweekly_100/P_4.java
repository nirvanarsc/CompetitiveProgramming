package leetcode.biweekly_contests.biweekly_100_199.biweekly_100;

public class P_4 {

    public long repairCars(int[] ranks, int cars) {
        long lo = 0;
        long hi = (long) 1e14;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            long curr = 0;
            for (int r : ranks) {
                //noinspection IntegerDivisionInFloatingPointContext
                curr += Math.sqrt(mid / r);
            }
            if (curr < cars) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
