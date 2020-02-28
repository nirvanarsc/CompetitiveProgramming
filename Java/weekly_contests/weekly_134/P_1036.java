package weekly_contests.weekly_134;

import java.util.HashSet;
import java.util.Set;

public class P_1036 {

    private static final long SIZE = 1000000L;
    private static final int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        final Set<Long> blockedSquares = new HashSet<>();
        for (int[] n : blocked) {
            blockedSquares.add(n[0] * SIZE + n[1]);
        }
        return check(blockedSquares, source, target, source, new HashSet<>())
               && check(blockedSquares, target, source, target, new HashSet<>());
    }

    private static boolean check(Set<Long> b, int[] s, int[] t, int[] cur, Set<Long> v) {
        if (Math.abs(cur[0] - s[0]) == 200 || Math.abs(cur[1] - s[1]) == 200
            || !v.isEmpty() && cur[0] == t[0] && cur[1] == t[1]) {
            return true;
        }
        v.add(cur[0] * SIZE + cur[1]);
        for (int[] dir : DIRS) {
            final int x = cur[0] + dir[0];
            final int y = cur[1] + dir[1];
            if (x < 0 || x == SIZE || y < 0 || y == SIZE
                || v.contains(x * SIZE + y) || b.contains(x * SIZE + y)) {
                continue;
            }
            if (check(b, s, t, new int[] { x, y }, v)) {
                return true;
            }
        }
        return false;
    }
}
