package leetcode.weekly_contests.weekly_300_399.weekly_360;

import java.util.List;

public class P_3 {

    public int minOperations(List<Integer> nums, int target) {
        final int[] f = new int[32];
        int res = 0;
        int j = (int) 1e9;
        for (int num : nums) {
            f[Integer.bitCount(num - 1)]++;
        }
        for (int i = 0; i < 31; i++) {
            if ((target & (1 << i)) != 0) {
                if (f[i] != 0) {
                    f[i]--;
                } else if (j == (int) 1e9) {
                    j = i;
                }
            }
            if (f[i] != 0 && j != (int) 1e9) {
                f[i]--;
                res += i - j;
                j = (int) 1e9;
            }
            f[i + 1] += f[i] / 2;
        }
        return j == (int) 1e9 ? res : -1;
    }
}
