package leetcode.biweekly_contests.biweekly_100_199.biweekly_114;

import java.util.List;

public class P_1 {

    public int minOperations(List<Integer> nums, int k) {
        long mask = 1L;
        final long target = (1L << (k + 1)) - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) <= k) {
                mask |= 1L << nums.get(i);
            }
            if (mask == target) {
                return nums.size() - i;
            }
        }
        return -1;
    }
}
