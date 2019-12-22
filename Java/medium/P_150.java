package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class P_150 {

    public static int evalRPN(String[] tokens) {
        final Set<String> operations = new HashSet<>(Arrays.asList("+", "/", "*", "-"));
        final Deque<Integer> stack = new LinkedList<>();
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

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        System.out.println(
                evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }

    private P_150() {}
}
