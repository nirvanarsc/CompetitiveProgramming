package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_150 {

    public int evalRPN(String[] tokens) {
        final Set<String> operations = new HashSet<>(Arrays.asList("+", "/", "*", "-"));
        final Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (operations.contains(s)) {
                final int right = stack.removeFirst();
                final int left = stack.removeFirst();
                switch (s) {
                    case "+":
                        stack.addFirst(left + right);
                        break;
                    case "/":
                        stack.addFirst(left / right);
                        break;
                    case "*":
                        stack.addFirst(left * right);
                        break;
                    default:
                        stack.addFirst(left - right);
                }
            } else {
                stack.addFirst(Integer.parseInt(s));
            }
        }

        return stack.removeFirst();
    }
}
