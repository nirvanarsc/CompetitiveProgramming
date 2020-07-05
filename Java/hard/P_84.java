package hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_84 {

    public int largestRectangleArea(int[] heights) {
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singleton(-1));
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack.size() > 1 && (i == heights.length || heights[stack.getFirst()] > heights[i])) {
                final int top = stack.removeFirst();
                final int area = heights[top] * (i - stack.getFirst() - 1);
                res = Math.max(res, area);
            }
            stack.addFirst(i);
        }
        return res;
    }
}
