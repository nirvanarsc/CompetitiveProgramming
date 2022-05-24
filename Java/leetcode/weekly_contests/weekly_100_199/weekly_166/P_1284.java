package leetcode.weekly_contests.weekly_100_199.weekly_166;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public final class P_1284 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minFlips(int[][] mat) {
        final Deque<int[][]> q = new ArrayDeque<>();
        final Set<String> seen = new HashSet<>();
        final int n = mat.length;
        final int m = mat[0].length;
        q.offerLast(mat);
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[][] curr = q.removeFirst();
                if (Arrays.deepEquals(curr, new int[n][m])) {
                    return level;
                }
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        final int[][] clone = copy(curr, n, m);
                        clone[x][y] ^= 1;
                        for (int[] dir : DIRS) {
                            final int nx = x + dir[0];
                            final int ny = y + dir[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                clone[nx][ny] ^= 1;
                            }
                        }
                        if (seen.add(Arrays.deepToString(clone))) {
                            q.offerLast(clone);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int[][] copy(int[][] mat, int n, int m) {
        final int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            res[i] = mat[i].clone();
        }
        return res;
    }
}
