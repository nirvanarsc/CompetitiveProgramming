package leetcode.biweekly_contests.biweekly_43;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1717 {

    public int maximumGain(String s, int x, int y) {
        String target;
        final int l;
        final int r;
        if (x > y) {
            target = "ab";
            l = x;
            r = y;
        } else {
            target = "ba";
            l = y;
            r = x;
        }
        final Deque<Character> dq = new ArrayDeque<>();
        final char[] w = s.toCharArray();
        int res = 0;
        for (char c : w) {
            if (!dq.isEmpty() && dq.getFirst() == target.charAt(0) && c == target.charAt(1)) {
                dq.removeFirst();
                res += l;
            } else {
                dq.addFirst(c);
            }
        }
        if ("ab".equals(target)) {
            target = "ba";
        } else {
            target = "ab";
        }
        final Deque<Character> dq2 = new ArrayDeque<>();
        while (!dq.isEmpty()) {
            final char c = dq.removeLast();
            if (!dq2.isEmpty() && dq2.getFirst() == target.charAt(0) && c == target.charAt(1)) {
                dq2.removeFirst();
                res += r;
            } else {
                dq2.addFirst(c);
            }
        }
        return res;
    }
}
