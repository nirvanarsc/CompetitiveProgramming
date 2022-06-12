package leetcode.biweekly_contests.biweekly_80;

import java.util.Arrays;

public class P_2 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        final int n = spells.length;
        final int m = potions.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = m - lowerBound(potions, (success + spells[i] - 1) / spells[i]);
        }
        return res;
    }

    private static int lowerBound(int[] arr, long target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
