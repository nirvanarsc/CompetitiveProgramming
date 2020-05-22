package weekly_contests.smarking_1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_439 {

    public String parseTernary(String expression) {
        final Deque<Deque<Character>> operators = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') {
                operators.addFirst(new ArrayDeque<>(Collections.singleton(expression.charAt(i - 1))));
            }
            if (expression.charAt(i) == ':') {
                operators.getFirst().addFirst(expression.charAt(i - 1));
                if (operators.getFirst().size() == 3) {
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
            if (i == expression.length() - 1) {
                operators.getFirst().addFirst(expression.charAt(i));
            }
        }
        while(operators.size() > 1) {
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
        final Deque<Character> top = operators.removeFirst();
        final Character second = top.removeFirst();
        final Character first = top.removeFirst();
        final Character ternary = top.removeFirst();
        if (ternary == 'T') {
            operators.getFirst().addFirst(first);
        } else {
            operators.getFirst().addFirst(second);
        }
        return String.valueOf(ternary == 'T' ? first : second);
    }
}
