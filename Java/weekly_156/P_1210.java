package weekly_156;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_1210 {

    public int minimumMoves(int[][] g) {
        final int n = g.length;
        final int[] start = { 0, 0, 0, 0 };
        final int[] target = { n - 1, n - 2, 0 };
        final Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        final Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            final int[] pos = q.poll();
            final int r = pos[0];
            final int c = pos[1];
            final int dr = pos[2];
            final int steps = pos[3];
            if (Arrays.equals(Arrays.copyOf(pos, 3), target)) {
                return steps;
            }
            if (seen.add(r + "," + c + ',' + dr)) {
                if (dr == 0) {
                    if (r + 1 < n && g[r + 1][c] + g[r + 1][c + 1] == 0) {
                        q.addAll(Arrays.asList(new int[] { r + 1, c, 0, steps + 1 },
                                               new int[] { r, c, 1, steps + 1 }));
                    }
                    if (c + 2 < n && g[r][c + 2] == 0) {
                        q.offer(new int[] { r, c + 1, 0, steps + 1 });
                    }
                } else {
                    if (c + 1 < n && g[r][c + 1] + g[r + 1][c + 1] == 0) {
                        q.addAll(Arrays.asList(new int[] { r, c + 1, 1, steps + 1 },
                                               new int[] { r, c, 0, steps + 1 }));
                    }
                    if (r + 2 < n && g[r + 2][c] == 0) {
                        q.offer(new int[] { r + 1, c, 1, steps + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
