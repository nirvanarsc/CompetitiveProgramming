package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_32 {

    public int longestValidParenthesesStack(String s) {
        int res = 0;
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singleton(-1));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addFirst(i);
            } else {
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    res = Math.max(res, i - stack.getFirst());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        int open = 0, close = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, 2 * open);
            } else if (close > open) {
                open = close = 0;
            }
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                res = Math.max(res, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return res;
    }
}
