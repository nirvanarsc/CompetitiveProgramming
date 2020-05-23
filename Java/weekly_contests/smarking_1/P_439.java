package weekly_contests.smarking_1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_439 {

    @SuppressWarnings("TailRecursion")
    public String parseTernary(String exp) {
        if (exp.length() == 1) {
            return exp;
        }
        final int i = capture(exp, 2, exp.length());
        if (exp.charAt(0) == 'T') {
            return parseTernary(exp.substring(2, i));
        } else {
            return parseTernary(exp.substring(i + 1));
        }
    }

    private static int capture(String exp, int lo, int hi) {
        int cnt = 0;
        for (int i = lo; i < hi; i++) {
            final char curr = exp.charAt(i);
            if (curr == ':' && cnt == 0) {
                return i;
            }
            if (curr == '?') {
                cnt++;
            } else if (curr == ':') {
                cnt--;
            }
        }
        return -1;
    }

    public String parseTernarySlow(String expression) {
        final Deque<Deque<Character>> operators = new ArrayDeque<>(Collections.singleton(new ArrayDeque<>()));
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') {
                operators.addFirst(new ArrayDeque<>(Collections.singleton(expression.charAt(i - 1))));
            }
            if (expression.charAt(i) == ':') {
                operators.getFirst().addFirst(expression.charAt(i - 1));
                processTernary(operators);
            }
            if (i == expression.length() - 1) {
                operators.getFirst().addFirst(expression.charAt(i));
            }
        }
        processTernary(operators);
        return String.valueOf(operators.removeFirst().removeFirst());
    }

    private static void processTernary(Deque<Deque<Character>> operators) {
        while (operators.getFirst().size() == 3) {
            final Deque<Character> top = operators.removeFirst();
            final Character second = top.removeFirst();
            final Character first = top.removeFirst();
            final Character ternary = top.removeFirst();
            if (ternary == 'T') {
                operators.getFirst().addFirst(first);
            } else {
                operators.getFirst().addFirst(second);
            }
        }
    }
}
