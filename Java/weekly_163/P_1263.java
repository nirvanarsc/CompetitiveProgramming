package weekly_163;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P_1263 {

    public int minPushBox(char[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int[] start = new int[2];
        int[] target = new int[2];
        int[] box = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final char ch = grid[i][j];
                if (ch == 'T') { target = new int[] { i, j }; }
                if (ch == 'S') { start = new int[] { i, j }; }
                if (ch == 'B') { box = new int[] { i, j }; }
            }
        }

        final int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {
                dist(box[0], box[1], target[0], target[1]), 0, start[0], start[1], box[0], box[1]
        });
        final Set<String> set = new HashSet<>();
        while (!pq.isEmpty()) {
            final int[] cur = pq.poll();
            final int moves = cur[1];
            final int sx = cur[2];
            final int sy = cur[3];
            final int bx = cur[4];
            final int by = cur[5];
            if (bx == target[0] && by == target[1]) {
                return moves;
            }
            final String state = sx + ":" + sy + '|' + bx + ':' + by;
            if (!set.contains(state)) {
                set.add(state);
                for (int[] dir : dirs) {
                    final int nx = sx + dir[0];
                    final int ny = sy + dir[1];
                    if (valid(nx, ny, m, n, grid)) {
                        final int[] next;
                        if (nx == bx && ny == by) {
                            final int nbx = bx + dir[0];
                            final int nby = by + dir[1];
                            if (!valid(nbx, nby, m, n, grid)) { continue; }
                            final int nextD = dist(nbx, nby, target[0], target[1]) + moves + 1;
                            next = new int[] { nextD, moves + 1, nx, ny, nbx, nby };
                        } else {
                            next = new int[] { cur[0], moves, nx, ny, bx, by };
                        }
                        pq.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private static boolean valid(int x, int y, int m, int n, char[][] g) {
        return x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1 && g[x][y] != '#';
    }

    private static int dist(int x, int y, int tx, int ty) {
        return Math.abs(x - tx) + Math.abs(y - ty);
    }
}
