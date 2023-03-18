package leetcode.biweekly_contests.biweekly_0_99.biweekly_45;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1750 {

    public int minimumLength(String s) {
        final Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            dq.addFirst(c);
        }
        while (dq.size() > 1 && dq.getFirst() == dq.getLast()) {
            final char c = dq.getFirst();
            while (!dq.isEmpty() && dq.getFirst() == c) { dq.removeFirst(); }
            while (!dq.isEmpty() && dq.getLast() == c) { dq.removeLast(); }
        }
        return dq.size();
    }
}
