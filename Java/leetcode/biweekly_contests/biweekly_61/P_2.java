package leetcode.biweekly_contests.biweekly_61;

import java.util.Arrays;

public class P_2 {

    public int[] findOriginalArray(int[] changed) {
        final int n = changed.length;
        @SuppressWarnings("ZeroLengthArrayAllocation")
        final int[] empty = new int[0];
        if (n % 2 != 0) {
            return empty;
        }
        final int[] f = new int[(int) (1e5 + 5)];
        for (int num : changed) {
            f[num]++;
        }
        final int[] res = new int[n / 2];
        Arrays.sort(changed);
        int idx = 0;
        for (int num : changed) {
            if (idx == res.length) {
                break;
            }
            if (f[num] == 0) {
                continue;
            }
            final int other = 2 * num;
            if (other >= f.length || f[other] == 0 || (other == 0 && f[0] < 2)) {
                return empty;
            }
            res[idx++] = num;
            f[other]--;
            f[num]--;
        }
        return res;
    }
}
