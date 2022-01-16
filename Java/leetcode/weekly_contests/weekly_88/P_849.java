package leetcode.weekly_contests.weekly_88;

public class P_849 {

    public int maxDistToClosest(int[] seats) {
        final int n = seats.length;
        int res;
        int i = 0;
        while (i < n && seats[i] == 0) {
            i++;
        }
        res = i;
        i = n - 1;
        while (i >= 0 && seats[i] == 0) {
            i--;
        }
        res = Math.max(res, n - 1 - i);
        for (int j = 0; j < n; j++) {
            if (seats[j] == 0) {
                i = j;
                while (i < n && seats[i] == 0) {
                    i++;
                }
                res = Math.max(res, (i - j + 1) / 2);
                j = i - 1;
            }
        }
        return res;
    }
}
