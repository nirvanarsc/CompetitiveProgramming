package leetcode.weekly_contests.weekly_154;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1190 {

    public String reverseParentheses(String s) {
        final Deque<StringBuilder> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addFirst(new StringBuilder());
            } else if (c == ')') {
                final StringBuilder sb = stack.removeFirst().reverse();
                if (!stack.isEmpty()) {
                    stack.getFirst().append(sb);
                } else {
                    stack.addFirst(sb);
                }
            } else {
                if (!stack.isEmpty()) {
                    stack.getFirst().append(c);
                } else {
                    stack.addFirst(new StringBuilder().append(c));
                }
            }
        }
        return stack.getFirst().toString();
    }
}
