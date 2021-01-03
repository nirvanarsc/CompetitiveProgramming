package leetcode.weekly_contests.weekly_222;

import java.util.Arrays;

public class P_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;
        int idx = 0;
        while (truckSize > 0 && idx < boxTypes.length) {
            final int curr = Math.min(truckSize, boxTypes[idx][0]);
            res += curr * boxTypes[idx][1];
            truckSize -= curr;
            idx++;
        }
        return res;
    }
}
