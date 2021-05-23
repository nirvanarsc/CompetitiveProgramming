package leetcode.weekly_contests.weekly_242;

public class P_1870 {

    public int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(mid, dist, hour)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return f(lo, dist, hour) ? lo : -1;
    }

    private static boolean f(int mid, int[] dist, double hour) {
        double curr = 0;
        for (int d : dist) {
            curr = Math.ceil(curr);
            curr += d / (double) mid;
        }
        return Double.compare(curr, hour) <= 0;
    }
}
