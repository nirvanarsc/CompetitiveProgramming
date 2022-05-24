package leetcode.weekly_contests.weekly_0_99.weekly_51;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_682 {

    public int calPoints(String[] ops) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (String op : ops) {
            if ('-' == op.charAt(0) || Character.isDigit(op.charAt(0))) {
                stack.addFirst(Integer.parseInt(op));
                res += stack.element();
            } else if ("C".equals(op)) {
                res -= stack.removeFirst();
            } else if ("D".equals(op)) {
                stack.addFirst(stack.element() * 2);
                res += stack.element();
            } else {
                final Integer top1 = stack.removeFirst();
                final Integer top2 = stack.removeFirst();
                stack.addFirst(top2);
                stack.addFirst(top1);
                stack.addFirst(top1 + top2);
                res += stack.element();
            }
        }
        return res;
    }
}
