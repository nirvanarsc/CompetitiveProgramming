package weekly_contests.weekly_131;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1021 {

    public String removeOuterParenthesesStack(String S) {
        final StringBuilder sb = new StringBuilder();
        final Deque<Character> stack = new ArrayDeque<>();
        int open = 0;
        for (char c : S.toCharArray()) {
            stack.addFirst(c);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
            }
            if (open == 0) {
                stack.removeLast();
                stack.removeFirst();
                while (!stack.isEmpty()) {
                    sb.append(stack.removeLast());
                }
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses(String s) {
        int openParentheses = 0;
        final StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(' && openParentheses++ > 0) { res.append('('); }
            if (c == ')' && openParentheses-- > 0) { res.append(')'); }
        }

        return res.toString();
    }
}
