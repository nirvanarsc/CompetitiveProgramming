package binarysearch.weekly_40;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1 {

    public int[] solve(int[] heights) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!dq.isEmpty() && heights[dq.getFirst()] <= heights[i]) {
                dq.removeFirst();
            }
            dq.addFirst(i);
        }
        final int[] res = new int[dq.size()];
        for (int i = 0; !dq.isEmpty(); i++) {
            res[i] = dq.removeLast();
        }
        return res;
    }
}
