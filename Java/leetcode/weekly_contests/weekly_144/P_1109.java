package leetcode.weekly_contests.weekly_144;

public class P_1109 {

    // Lazy
    public int[] corpFlightBookings(int[][] bookings, int n) {
        final int[] res = new int[n];
        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public int[] corpFlightBookingsBF(int[][] bookings, int n) {
        final int[] res = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i < booking[1]; i++) {
                res[i] += booking[2];
            }
        }
        return res;
    }
}
