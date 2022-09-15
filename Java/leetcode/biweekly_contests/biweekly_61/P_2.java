package leetcode.biweekly_contests.biweekly_61;

import java.util.Arrays;

public class P_2 {

    public int[] findOriginalArray(int[] changed) {
        final int n = changed.length;
        final int m = (int) (1e5 + 5);
        if (n % 2 != 0) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0];
        }
        final int[] f = new int[m];
        final int[] res = new int[n / 2];
        for (int num : changed) {
            f[num]++;
        }
        Arrays.sort(changed);
        int idx = 0;
        for (int num : changed) {
            if (idx == n / 2) {
                break;
            }
            if (f[num] == 0) {
                continue;
            }
            final int other = 2 * num;
            if (other >= m || f[other] == 0 || (other == 0 && f[0] < 2)) {
                //noinspection ZeroLengthArrayAllocation
                return new int[0];
            }
            res[idx++] = num;
            f[other]--;
            f[num]--;
        }
        return res;
    }
}
