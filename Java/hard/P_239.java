package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) { return nums; }
        final Deque<Integer> dq = new ArrayDeque<>();
        final int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.getFirst() < i - k + 1) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
