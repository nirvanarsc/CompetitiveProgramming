package leetcode.weekly_contests.weekly_133;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1030 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        final int[][] res = new int[rows * cols][2];
        final boolean[][] visited = new boolean[rows][cols];
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] { rCenter, cCenter });
        visited[rCenter][cCenter] = true;
        int i = 0;
        while (!queue.isEmpty()) {
            final int[] ints = queue.removeFirst();
            res[i++] = ints;
            for (int[] dir : DIRS) {
                final int newX = ints[0] + dir[0];
                final int newY = ints[1] + dir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offerLast(new int[] { newX, newY });
                }
            }
        }
        return res;
    }
}
