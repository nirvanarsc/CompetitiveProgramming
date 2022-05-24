package leetcode.weekly_contests.weekly_200_299.weekly_275;

import java.util.Arrays;

public class P_4 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        final int n = plantTime.length;
        final int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { plantTime[i], growTime[i] };
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                : Integer.compare(b[1], a[1]));
        int res = 0;
        int currX = 0;
        for (int[] p : arr) {
            currX += p[0];
            res = Math.max(res, currX + p[1]);
        }
        return res;
    }
}
