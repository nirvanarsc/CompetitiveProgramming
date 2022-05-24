package leetcode.weekly_contests.weekly_0_99.weekly_24;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_544 {

    public String findContestMatch(int n) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(String.valueOf(i + 1));
        }
        for (int i = 1; i < n; i <<= 1) {
            deque = round(deque);
        }
        return deque.removeFirst();
    }

    private static Deque<String> round(Deque<String> dq) {
        final int n = dq.size();
        final Deque<String> next = new ArrayDeque<>();
        for (int i = 0; i < n >> 1; i++) {
            next.addLast('(' + dq.removeFirst() + ',' + dq.removeLast() + ')');
        }
        return next;
    }
}
