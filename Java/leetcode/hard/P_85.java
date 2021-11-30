package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        final int m = matrix[0].length;
        final int[] curr = new int[m];
        for (char[] row : matrix) {
            for (int j = 0; j < m; j++) {
                if (row[j] == '0') {
                    curr[j] = 0;
                } else {
                    curr[j]++;
                }
            }
            res = Math.max(res, largestRectangleArea(curr));
        }
        return res;
    }

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
