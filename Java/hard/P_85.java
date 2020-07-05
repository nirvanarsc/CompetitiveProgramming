package hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        final int[] currRow = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (row[i] == '1') {
                    currRow[i]++;
                } else {
                    currRow[i] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(currRow));
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
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
