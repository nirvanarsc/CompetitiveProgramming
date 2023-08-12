package leetcode.biweekly_contests.biweekly_100_199.biweekly_108;

import java.util.HashSet;
import java.util.Set;

public class P_4 {

    private static final int[][][] DIRS = {
            { { 0, 1 }, { 1, 0 }, { 1, 1 } },
            { { 0, -1 }, { 1, -1 }, { 1, 0 } },
            { { 0, -1 }, { -1, -1 }, { -1, 0 } },
            { { -1, 0 }, { -1, 1 }, { 0, 1 } }
    };

    public long[] countBlackBlocks(int n, int m, int[][] coordinates) {
        final long[] res = new long[5];
        final Set<Long> b = new HashSet<>();
        final Set<Long> seen = new HashSet<>();
        for (int[] c : coordinates) {
            b.add((long) c[0] * m + c[1]);
        }
        res[0] = (long) (n - 1) * (m - 1);
        for (int[] c : coordinates) {
            outer:
            for (int[][] blockDirs : DIRS) {
                int curr = 1;
                long min = (long) c[0] * m + c[1];
                for (int[] dir : blockDirs) {
                    final int nx = c[0] + dir[0];
                    final int ny = c[1] + dir[1];
                    if (!(0 <= nx && nx < n && 0 <= ny && ny < m)) {
                        continue outer;
                    }
                    final long v = (long) nx * m + ny;
                    curr += b.contains(v) ? 1 : 0;
                    min = Math.min(min, v);
                }
                if (seen.add(min)) {
                    res[curr]++;
                    res[0]--;
                }
            }
        }
        return res;
    }
}
