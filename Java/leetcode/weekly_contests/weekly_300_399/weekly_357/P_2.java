package leetcode.weekly_contests.weekly_300_399.weekly_357;

import java.util.List;

public class P_2 {

    public boolean canSplitArray(List<Integer> nums, int m) {
        final int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }
        return n < 3;
    }
}
