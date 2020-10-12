package leetcode.weekly_contests.weekly_196;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1504 {

    public int numSubmat(int[][] mat) {
        final int m = mat[0].length;
        final int[] currRow = new int[m];
        int res = 0;
        for (int[] row : mat) {
            for (int i = 0; i < m; i++) {
                if (row[i] == 1) {
                    currRow[i]++;
                } else {
                    currRow[i] = 0;
                }
            }
            res += countRectangles(currRow);
        }
        return res;
    }

    public static int countRectangles(int[] heights) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        final int[] sum = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && (heights[stack.getFirst()] >= heights[i])) {
                stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                sum[i] = sum[stack.getFirst()] + heights[i] * (i - stack.getFirst());
            } else {
                sum[i] = heights[i] * (i + 1);
            }
            res += sum[i];
            stack.addFirst(i);
        }
        return res;
    }
}
