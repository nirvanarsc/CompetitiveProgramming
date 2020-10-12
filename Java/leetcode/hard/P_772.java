package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

public class P_772 {

    public int calculate(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;
        final Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (++i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                }
                l2 = o2 == 1 ? l2 * num : l2 / num;
                i--;
            } else if (c == '(') {
                stack.addFirst(l1);
                stack.addFirst(o1);
                stack.addFirst(l2);
                stack.addFirst(o2);
                l1 = 0;
                o1 = 1;
                l2 = 1;
                o2 = 1;
            } else if (c == ')') {
                final int num = l1 + o1 * l2;
                o2 = stack.removeFirst();
                l2 = stack.removeFirst();
                o1 = stack.removeFirst();
                l1 = stack.removeFirst();
                l2 = o2 == 1 ? l2 * num : l2 / num;
            } else if (c == '*' || c == '/') {
                o2 = c == '*' ? 1 : -1;
            } else if (c == '+' || c == '-') {
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    o1 = -1;
                    continue;
                }
                l1 += o1 * l2;
                o1 = c == '+' ? 1 : -1;
                l2 = 1;
                o2 = 1;
            }
        }

        return l1 + o1 * l2;
    }
}
