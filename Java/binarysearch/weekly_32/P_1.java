package binarysearch.weekly_32;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1 {



    public int solve(int[] nums) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && nums[dq.getFirst()] <= nums[i]) {
                dq.removeFirst();
            }
            dq.addFirst(i);
            res += nums[dq.getLast()] - nums[i];
        }
        return res;
    }
}
