package weekly_contests.weekly_143;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_1106 {

    public boolean parseBoolExpr(String expression) {
        final Deque<Character> operations = new ArrayDeque<>();
        final Deque<List<Character>> operands = new ArrayDeque<>(Collections.singletonList(new ArrayList<>()));

        for (char c : expression.toCharArray()) {
            if ("|&!".indexOf(c) != -1) {
                operations.addFirst(c);
            } else if (c == '(') {
                operands.addFirst(new ArrayList<>());
            } else if (c == ')') {
                final List<Character> list = operands.removeFirst();
                final Character op = operations.removeFirst();
                operands.getFirst().add(parseExpression(list, op) ? 't' : 'f');
            } else if (c != ',') {
                operands.getFirst().add(c);
            }
        }

        return operands.getFirst().get(0) == 't';
    }

    private static boolean parseExpression(List<Character> list, Character op) {
        switch (op) {
            case '&':
                return list.stream()
                           .map(i -> i == 't')
                           .reduce((l, r) -> l && r)
                           .orElse(false);
            case '|':
                return list.stream()
                           .map(i -> i == 't')
                           .reduce((l, r) -> l || r)
                           .orElse(false);
            default:
                return list.get(0) != 't';
        }
    }
}
