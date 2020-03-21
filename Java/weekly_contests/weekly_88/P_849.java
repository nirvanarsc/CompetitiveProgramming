package weekly_contests.weekly_88;

public class P_849 {

    public int maxDistToClosest(int[] seats) {
        final int n = seats.length;
        int max = 0, i = 0;
        while (i < seats.length) {
            while (i < n && seats[i] == 1) {
                i++;
            }
            final int j = i;
            while (i < n && seats[i] == 0) {
                i++;
            }
            if (j == 0 || i == n) {
                max = Math.max(max, i - j);
            } else {
                max = Math.max(max, (i - j + 1) / 2);
            }
        }
        return max;
    }
}
