package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_20 {

    public boolean isValid(String s) {
        final Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                dq.addFirst(c);
            } else if (c == ')') {
                if (dq.isEmpty() || dq.getFirst() != '(') {
                    return false;
                }
                dq.removeFirst();
            } else if (c == '}') {
                if (dq.isEmpty() || dq.getFirst() != '{') {
                    return false;
                }
                dq.removeFirst();
            } else if (c == ']') {
                if (dq.isEmpty() || dq.getFirst() != '[') {
                    return false;
                }
                dq.removeFirst();
            }
        }
        return dq.isEmpty();
    }
}
