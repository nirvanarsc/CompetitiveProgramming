package leetcode.weekly_contests.weekly_133;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1030 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        final int[][] res = new int[R * C][2];
        final boolean[][] visited = new boolean[R][C];
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] { r0, c0 });
        visited[r0][c0] = true;
        int i = 0;
        while (!queue.isEmpty()) {
            final int[] ints = queue.removeFirst();
            res[i++] = ints;
            for (int[] dir : DIRS) {
                final int newX = ints[0] + dir[0];
                final int newY = ints[1] + dir[1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offerLast(new int[] { newX, newY });
                }
            }
        }
        return res;
    }
}
