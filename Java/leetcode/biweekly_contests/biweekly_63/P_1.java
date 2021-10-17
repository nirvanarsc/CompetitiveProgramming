package leetcode.biweekly_contests.biweekly_63;

import java.util.Arrays;

public class P_1 {

    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        final int n = seats.length;
        for (int i = 0; i < n; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
