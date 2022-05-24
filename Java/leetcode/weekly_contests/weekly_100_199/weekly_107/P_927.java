package leetcode.weekly_contests.weekly_100_199.weekly_107;

import java.util.HashMap;
import java.util.Map;

public class P_927 {

    public int[] threeEqualParts(int[] arr) {
        final int n = arr.length;
        final Map<Integer, Integer> map = new HashMap<>();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ones += 1;
                map.put(ones, i);
            }
        }
        if (ones % 3 != 0) {
            return new int[] { -1, -1 };
        }
        if (ones == 0) {
            return new int[] { 0, n - 1 };
        }
        final int target = ones / 3;
        int ll = map.get(target + 1);
        int rr = map.get(2 * target + 1);
        for (int i = map.get(1); rr < n; i++, ll++, rr++) {
            if (arr[i] != arr[ll] || arr[ll] != arr[rr]) {
                return new int[] { -1, -1 };
            }
        }
        final int necessaryL = n - map.get(2 * target + 1);
        final int resL = map.get(1) + necessaryL - 1;
        final int resR = map.get(target + 1) + necessaryL;
        return new int[] { resL, resR };
    }
}
