package leetcode.weekly_contests.weekly_300_399.weekly_304;

public class P_2 {

    public int maximumGroups(int[] grades) {
        int lo = 1;
        int hi = (int) 1e4;
        final int n = grades.length;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (mid * (mid + 1) > 2 * n) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
