package leetcode.weekly_contests.weekly_18b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                stack.removeFirst();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.getFirst());
            stack.addFirst(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
