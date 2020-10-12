package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_42 {

    public int trapStack(int[] height) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.getFirst()]) {
                final int prev = stack.removeFirst();
                if (!stack.isEmpty()) {
                    final int minHeight = Math.min(height[stack.getFirst()], height[i]);
                    water += (minHeight - height[prev]) * (i - stack.getFirst() - 1);
                }
            }
            stack.addFirst(i);
        }
        return water;
    }

    public static int trap(int[] height) {
        int res = 0, start = 0, end = height.length - 1;
        int mL = 0, mR = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                if (height[start] >= mL) {
                    mL = height[start];
                } else {
                    res += mL - height[start];
                }
                start++;
            } else {
                if (height[end] >= mR) {
                    mR = height[end];
                } else {
                    res += mR - height[end];
                }
                end--;
            }
        }
        return res;
    }
}
