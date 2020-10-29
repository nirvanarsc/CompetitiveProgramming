package leetcode.weekly_contests.weekly_88;

public class P_849 {

    public int maxDistToClosest(int[] seats) {
        final int n = seats.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                int j = i + 1;
                while (j < n && seats[j] == 0) {
                    j++;
                }
                res = Math.max(res, (j - i) / 2);
                i = j - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                res = Math.max(res, i);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                res = Math.max(res, n - i - 1);
                break;
            }
        }
        return res;
    }
}
