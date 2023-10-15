package leetcode.weekly_contests.weekly_300_399.weekly_363;

import java.util.List;

public class P_1 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        final int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
