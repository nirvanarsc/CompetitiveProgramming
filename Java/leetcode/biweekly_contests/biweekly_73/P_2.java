package leetcode.biweekly_contests.biweekly_73;

import java.util.Arrays;
import java.util.Comparator;

public class P_2 {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        final int n = nums.length;
        final long[][] indexed = new long[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new long[] { f(nums[i], mapping), i };
        }
        Arrays.sort(indexed, Comparator.comparingLong(a -> a[0]));
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(int) indexed[i][1]];
        }
        return res;
    }

    private static long f(int num, int[] mapping) {
        final char[] w = String.valueOf(num).toCharArray();
        for (int i = 0; i < w.length; i++) {
            w[i] = (char) (mapping[w[i] - '0'] + '0');
        }
        return Long.parseLong(new String(w));
    }
}
