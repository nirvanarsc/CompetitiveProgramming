package leetcode.weekly_contests.weekly_200_299.weekly_222;

import java.util.Arrays;

public class P_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;
        for (int[] box : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            final int maxTake = Math.min(truckSize, box[0]);
            truckSize -= maxTake;
            res += maxTake * box[1];
        }
        return res;
    }
}
