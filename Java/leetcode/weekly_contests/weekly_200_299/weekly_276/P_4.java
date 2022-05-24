package leetcode.weekly_contests.weekly_200_299.weekly_276;

import java.util.Arrays;

public class P_4 {

    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        final int m = batteries.length;
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (batteries[i] > sum / n) {
                n--;
                sum -= batteries[i];
            } else {
                return sum / n;
            }
        }
        return -1;
    }
}
