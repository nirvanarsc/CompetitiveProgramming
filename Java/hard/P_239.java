package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) { return nums; }
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) { dq.removeLast(); }
            dq.addLast(i);
        }

        final int[] res = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            res[i - k] = nums[dq.getFirst()];
            if (dq.getFirst() == i - k) { dq.removeFirst(); }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) { dq.removeLast(); }
            dq.addLast(i);
        }
        res[res.length - 1] = nums[dq.getFirst()];
        return res;
    }
}
