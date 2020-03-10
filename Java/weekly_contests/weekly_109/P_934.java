package weekly_contests.weekly_109;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_934 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestBridge(int[][] A) {
        final int n = A.length;
        final int m = A[0].length;
        final boolean[][] visited = new boolean[n][m];
        final Deque<int[]> q = new ArrayDeque<>();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        floodFill(A, x, y, visited, q);
        int res = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                final int[] curr = q.removeFirst();
                if (A[curr[0]][curr[1]] == 1) {
                    return res - 1;
                }
                for (int[] dir : DIRS) {
                    final int newX = curr[0] + dir[0];
                    final int newY = curr[1] + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]
                        && A[newX][newY] != 2) {
                        visited[newX][newY] = true;
                        q.offerLast(new int[] { newX, newY });
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static void floodFill(int[][] A, int r, int c, boolean[][] visited, Deque<int[]> q) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length || A[r][c] != 1) {
            return;
        }
        visited[r][c] = true;
        q.offerLast(new int[] { r, c });
        A[r][c] = 2;
        for (int[] dir : DIRS) {
            floodFill(A, r + dir[0], c + dir[1], visited, q);
        }
    }
}
