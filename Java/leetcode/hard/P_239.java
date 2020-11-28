package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final int n = nums.length;
        final int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i + 1 >= k) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
