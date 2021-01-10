package leetcode.biweekly_contests.biweekly_43;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1717 {

    public int maximumGain(String s, int x, int y) {
        final Deque<Character> stack = new ArrayDeque<>();
        final Deque<Character> stack2 = new ArrayDeque<>();
        int result = 0;
        final int max = Math.max(x, y);
        final int min = Math.min(x, y);
        final char first = (x > y) ? 'a' : 'b';
        final char second = (x > y) ? 'b' : 'a';
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.getFirst() == first && c == second) {
                stack.removeFirst();
                result += max;
            } else {
                stack.addFirst(c);
            }
        }
        while (!stack.isEmpty()) {
            final char c = stack.removeFirst();
            if (!stack2.isEmpty() && stack2.getFirst() == first && c == second) {
                stack2.removeFirst();
                result += min;
            } else {
                stack2.addFirst(c);
            }
        }
        return result;
    }
}
