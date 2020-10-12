package leetcode.weekly_contests.weekly_71;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_780 {

    public boolean reachingPointsBFS(int sx, int sy, int tx, int ty) {
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(new int[] { sx, sy }));
        while (!q.isEmpty()) {
            final int[] curr = q.removeFirst();
            if (curr[0] == tx && curr[1] == ty) {
                return true;
            }
            if (curr[0] + curr[1] <= tx) {
                q.offerLast(new int[] { curr[0] + curr[1], curr[1] });
            }
            if (curr[0] + curr[1] <= ty) {
                q.offerLast(new int[] { curr[0], curr[0] + curr[1] });
            }
        }
        return false;
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        if (sx == tx && sy <= ty && (ty - sy) % sx == 0) {
            return true;
        }
        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
