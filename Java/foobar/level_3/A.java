package foobar.level_3;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class A {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 0 }
        }));
        System.out.println(solution(new int[][] {
                { 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0 }
        }));
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int solution(int[][] map) {
        final int n = map.length;
        final int m = map[0].length;
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { 0, 0, 1 });
        final boolean[][][] seen = new boolean[n][m][2];
        for (int level = 1; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                final int skip = curr[2];
                if (x == n - 1 && y == m - 1) {
                    return level;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 1) {
                            if (skip == 1 && !seen[nx][ny][skip]) {
                                seen[nx][ny][1] = true;
                                dq.offerLast(new int[] { nx, ny, 0 });
                            }
                        } else {
                            if (!seen[nx][ny][skip]) {
                                seen[nx][ny][skip] = true;
                                dq.offerLast(new int[] { nx, ny, skip });
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}

