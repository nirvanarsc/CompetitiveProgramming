package leetcode.weekly_contests.weekly_200_299.weekly_267;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int n = tickets.length;
        for (int i = 0; i < n; i++) {
            dq.offerLast(new int[] { tickets[i], i });
        }
        for (int res = 1; !dq.isEmpty(); res++) {
            final int[] curr = dq.removeFirst();
            if (curr[0] == 1 && curr[1] == k) {
                return res;
            }
            if (curr[0] > 1) {
                dq.offerLast(new int[] { curr[0] - 1, curr[1] });
            }
        }
        return -1;
    }
}
