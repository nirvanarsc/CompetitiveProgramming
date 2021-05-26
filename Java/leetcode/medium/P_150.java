package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_150 {

    public int evalRPN(String[] tokens) {
        final Deque<Integer> ops = new ArrayDeque<>();
        final String operands = "+-*/";
        for (String t : tokens) {
            if (operands.contains(t)) {
                ops.addFirst(eval(ops.removeFirst(), ops.removeFirst(), t.charAt(0)));
            } else {
                ops.addFirst(Integer.parseInt(t));
            }
        }
        return ops.removeFirst();
    }

    private static int eval(int a, int b, char c) {
        switch (c) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '/':
                return b / a;
            case '*':
                return b * a;
            default:
                return -1;
        }
    }
}
