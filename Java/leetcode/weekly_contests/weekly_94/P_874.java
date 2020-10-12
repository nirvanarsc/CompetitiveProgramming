package leetcode.weekly_contests.weekly_94;

import java.util.HashSet;
import java.util.Set;

public class P_874 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int robotSim(int[] commands, int[][] obstacles) {
        final Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }
        int dir = 0, x = 0, y = 0, res = 0;
        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 1; i <= c; i++) {
                    x += DIRS[dir][0];
                    y += DIRS[dir][1];
                    if (set.contains(x + "," + y)) {
                        x -= DIRS[dir][0];
                        y -= DIRS[dir][1];
                    }
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }
}
