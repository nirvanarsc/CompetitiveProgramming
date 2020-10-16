package leetcode.weekly_contests.weekly_106;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_921 {

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

    public int minAddToMakeValid(String S) {
        int open = 0;
        int res = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    res++;
                }
            }
        }
        return res + open;
    }
}
