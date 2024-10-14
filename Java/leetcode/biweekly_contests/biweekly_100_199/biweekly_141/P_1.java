package leetcode.biweekly_contests.biweekly_100_199.biweekly_141;

import java.util.List;

public class P_1 {

    public int[] minBitwiseArray(List<Integer> nums) {
        final int n = nums.size();
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = f(nums.get(i));
        }
        return res;
    }

    private static int f(int num) {
        for (int i = 0; i < 30; i++) {
            if ((num & (1 << i)) != 0 && (num & (1 << (i + 1))) == 0) {
                num ^= 1 << i;
                break;
            }
        }
        return num == 0 ? -1 : num;
    }
}
