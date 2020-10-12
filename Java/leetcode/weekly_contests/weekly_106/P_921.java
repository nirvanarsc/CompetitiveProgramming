package leetcode.weekly_contests.weekly_106;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_921 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minAddToMakeValidStack(String S) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peekFirst() == '(' && c == ')') {
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }
        return stack.size();
    }

    public int minAddToMakeValid(String string) {
        int open = 0, closed = 0;
        for (char c : string.toCharArray()) {
            if (c == ')') {
                if (open > 0) { open--; } else { closed++; }
            } else {
                open++;
            }
        }
        return open + closed;
    }
}
