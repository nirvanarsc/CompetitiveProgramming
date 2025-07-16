package leetcode.biweekly_contests.biweekly_100_199.biweekly_156;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    public int minOperations(int[] nums) {
        final boolean[] seen = new boolean[(int) (1e5 + 5)];
        seen[0] = true;
        final Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        for (final int curr : nums) {
            while (!dq.isEmpty() && dq.getFirst() > curr) {
                seen[dq.removeFirst()] = false;
            }
            if (!seen[curr]) {
                res++;
                seen[curr] = true;
            }
            dq.addFirst(curr);
        }
        return res;
    }
}
