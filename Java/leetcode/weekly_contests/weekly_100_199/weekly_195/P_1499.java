package leetcode.weekly_contests.weekly_100_199.weekly_195;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1499 {

    public int findMaxValueOfEquation(int[][] points, int k) {
        final Deque<int[]> dq = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int[] p : points) {
            final int x = p[0];
            final int y = p[1];
            while (!dq.isEmpty() && dq.getFirst()[1] < x - k) {
                dq.removeFirst();
            }
            if (!dq.isEmpty()) {
                res = Math.max(res, dq.getFirst()[0] + y + x);
            }
            while (!dq.isEmpty() && dq.getLast()[0] <= y - x) {
                dq.removeLast();
            }
            dq.addLast(new int[] { y - x, x });
        }
        return res;
    }
}
