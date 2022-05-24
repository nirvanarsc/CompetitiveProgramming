package leetcode.weekly_contests.weekly_200_299.weekly_261;

import java.util.Arrays;

public class P_2 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        final int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        final int diff = ((m + n) * mean) - sum;
        if (diff < n || diff > 6 * n) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0];
        }
        final int[] res = new int[n];
        Arrays.fill(res, diff / n);
        for (int i = 0; i < (diff % n); i++) {
            res[i]++;
        }
        return res;
    }
}
