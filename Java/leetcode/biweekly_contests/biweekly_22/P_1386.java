package leetcode.biweekly_contests.biweekly_22;

import java.util.HashMap;
import java.util.Map;

public class P_1386 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        final Map<Integer, Integer> rowMap = new HashMap<>();
        for (int[] r : reservedSeats) {
            rowMap.merge(r[0], 1 << (r[1] - 1), (a, b) -> a | b);
        }
        int res = 2 * n - 2 * rowMap.size();
        for (int k : rowMap.values()) {
            res += helper(k);
        }
        return res;
    }

    private static int helper(int reserved) {
        if (((reserved >> 1) & ((1 << 8) - 1)) == 0) {
            return 2;
        }
        if (((reserved >> 1) & ((1 << 4) - 1)) == 0) {
            return 1;
        }
        if (((reserved >> 3) & ((1 << 4) - 1)) == 0) {
            return 1;
        }
        if (((reserved >> 5) & ((1 << 4) - 1)) == 0) {
            return 1;
        }
        return 0;
    }
}
