package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_286 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) { return; }
        final int n = rooms.length;
        final int m = rooms[0].length;
        final Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.offerLast(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            final int[] curr = q.removeFirst();
            for (int[] dir : DIRS) {
                final int nx = curr[0] + dir[0];
                final int ny = curr[1] + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && rooms[nx][ny] == Integer.MAX_VALUE) {
                    rooms[nx][ny] = rooms[curr[0]][curr[1]] + 1;
                    q.offerLast(new int[] { nx, ny });
                }
            }
        }
    }

    public void wallsAndGatesDFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private static void dfs(int[][] rooms, int r, int c, int distance) {
        if (r < 0 || r == rooms.length || c < 0 || c == rooms[r].length || rooms[r][c] < distance) {
            return;
        }
        rooms[r][c] = distance;
        for (int[] dir : DIRS) {
            dfs(rooms, r + dir[0], c + dir[1], distance + 1);
        }
    }
}
