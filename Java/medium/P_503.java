package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_503 {

    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }

        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = maxIdx; i > maxIdx - nums.length; i--) {
            final int idx = (i + nums.length) % nums.length;
            while (!stack.isEmpty() && stack.peekFirst() <= nums[idx]) {
                stack.removeFirst();
            }
            final int temp = nums[idx];
            nums[idx] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.addFirst(temp);
        }
        return nums;
    }
}
