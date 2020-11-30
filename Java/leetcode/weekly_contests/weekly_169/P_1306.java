package leetcode.weekly_contests.weekly_169;

import java.util.ArrayDeque;
import java.util.Deque;

public final class P_1306 {

    public boolean canReach(int[] arr, int start) {
        final Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(start);
        final int n = arr.length;
        final boolean[] seen = new boolean[n];
        while (!dq.isEmpty()) {
            final int curr = dq.removeFirst();
            if (arr[curr] == 0) {
                return true;
            }
            final int move = arr[curr];
            if (curr - move >= 0 && !seen[curr - move]) {
                seen[curr - move] = true;
                dq.offerLast(curr - move);
            }
            if (curr + move < n && !seen[curr + move]) {
                seen[curr + move] = true;
                dq.offerLast(curr + move);
            }
        }
        return false;
    }
}
