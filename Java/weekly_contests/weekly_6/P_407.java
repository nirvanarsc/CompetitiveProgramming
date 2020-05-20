package weekly_contests.weekly_6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_407 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int trapRainWater(int[][] heightMap) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final int n = heightMap.length;
        final int m = heightMap[0].length;
        int max = Integer.MIN_VALUE;
        int res = 0;
        final boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { heightMap[i][0], i, 0 });
            pq.add(new int[] { heightMap[i][m - 1], i, m - 1 });
        }
        for (int i = 0; i < m; i++) {
            pq.add(new int[] { heightMap[0][i], 0, i });
            pq.add(new int[] { heightMap[n - 1][i], n - 1, i });
        }
        while (!pq.isEmpty()) {
            final int[] remove = pq.remove();
            if (visited[remove[1]][remove[2]]) {
                continue;
            }
            visited[remove[1]][remove[2]] = true;
            if (remove[0] < max) {
                res += max - remove[0];
            }
            max = Math.max(max, remove[0]);
            for (int[] dir : DIRS) {
                final int nx = remove[1] + dir[0];
                final int ny = remove[2] + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    pq.offer(new int[] { heightMap[nx][ny], nx, ny });
                }
            }
        }
        return res;
    }
}
