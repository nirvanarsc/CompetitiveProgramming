package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_1063 {

    public int validSubarrays(int[] nums) {
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singletonList(nums[0]));
        int res = nums.length;
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peekFirst()) {
                stack.removeFirst();
            }
            res += stack.size();
            stack.addFirst(nums[i]);
        }
        return res;
    }
}
