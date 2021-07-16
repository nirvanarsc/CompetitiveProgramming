package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_42 {

    public int trapStack(int[] height) {
        final Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!dq.isEmpty() && height[i] > height[dq.getFirst()]) {
                final int prev = dq.removeFirst();
                if (!dq.isEmpty()) {
                    final int minH = Math.min(height[dq.getFirst()], height[i]);
                    res += (minH - height[prev]) * (i - dq.getFirst() - 1);
                }
            }
            dq.addFirst(i);
        }
        return res;
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
