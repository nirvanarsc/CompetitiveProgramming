package weekly_contests.weekly_178;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1368 {

    public int minCost(int[][] grid) {
        final int[][] dirs = { { 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        final PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.add(new int[] { 0, 0, 0 });
        while (!q.isEmpty()) {
            final int[] ints = q.remove();
            if (ints[0] == grid.length - 1 && ints[1] == grid[0].length - 1) {
                return ints[2];
            }
            final int currX = ints[0];
            final int currY = ints[1];
            visited[currX][currY] = true;
            for (int i = 1; i < dirs.length; i++) {
                final int nX = currX + dirs[i][0];
                final int nY = currY + dirs[i][1];
                final int nC = i == grid[currX][currY] ? ints[2] : ints[2] + 1;
                if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length && !visited[nX][nY]) {
                    q.add(new int[] { nX, nY, nC });
                }
            }
        }
        return -1;
    }
}
