import java.util.Deque;
import java.util.LinkedList;

public final class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        final Deque<Integer> stack = new LinkedList<>();
        int i, res = 0;
        for (i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peekFirst()] <= heights[i]) {
                stack.addFirst(i++);
            } else {
                final int top = stack.removeFirst();
                final int area = stack.isEmpty() ? heights[top] * i : heights[top] * (i - stack.peek() - 1);
                res = Math.max(res, area);
            }
        }

        while (!stack.isEmpty()) {
            final int top = stack.removeFirst();
            final int area = stack.isEmpty() ? heights[top] * i : heights[top] * (i - stack.peek() - 1);
            res = Math.max(res, area);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 1, 2, 3, 1 }));
    }

    private LargestRectangleHistogram() {}
}
