package leetcode.weekly_contests.weekly_300_399.weekly_353;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    public boolean checkArray(int[] nums, int k) {
        final int n = nums.length;
        final Deque<int[]> dq = new ArrayDeque<>();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && i == dq.getFirst()[1]) {
                diff -= dq.removeFirst()[0];
            }
            nums[i] -= diff;
            if (nums[i] > 0) {
                if (i + k - 1 >= n) {
                    return false;
                }
                diff += nums[i];
                dq.addLast(new int[] { nums[i], i + k });
                nums[i] = 0;
            } else if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
