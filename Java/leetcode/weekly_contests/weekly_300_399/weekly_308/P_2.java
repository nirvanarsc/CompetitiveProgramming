package leetcode.weekly_contests.weekly_300_399.weekly_308;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    public String removeStars(String s) {
        final Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                dq.removeFirst();
            } else {
                dq.addFirst(c);
            }
        }
        int n = dq.size();
        final char[] res = new char[n];
        while (!dq.isEmpty()) {
            res[--n] = dq.removeFirst();
        }
        return new String(res);
    }
}
