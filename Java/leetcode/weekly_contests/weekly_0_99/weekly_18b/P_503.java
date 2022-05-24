package leetcode.weekly_contests.weekly_0_99.weekly_18b;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_503 {

    public int[] nextGreaterElements(int[] nums) {
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= nums[i]) {
                stack.removeFirst();
            }
            stack.addFirst(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= nums[i]) {
                stack.removeFirst();
            }
            final int t = nums[i];
            nums[i] = stack.isEmpty() ? -1 : stack.getFirst();
            stack.addFirst(t);
        }
        return nums;
    }

    public int[] nextGreaterElementsMax(int[] nums) {
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
