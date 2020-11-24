package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_227 {

    public int calculate(String s) {
        final Deque<Integer> operands = new ArrayDeque<>();
        final Deque<Character> op1 = new ArrayDeque<>();
        final Deque<Character> op2 = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int j = i;
                int num = 0;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    num = num * 10 + chars[j++] - '0';
                }
                while (!op1.isEmpty()) {
                    final char op = op1.removeFirst();
                    if (op == '*') {
                        num *= operands.removeFirst();
                    } else {
                        num = operands.removeFirst() / num;
                    }
                }
                operands.addFirst(num);
                i = j - 1;
            } else if (c == '*' || c == '/') {
                op1.addFirst(c);
            } else {
                op2.addFirst(c);
            }
        }
        int res = operands.removeLast();
        while (!operands.isEmpty()) {
            final char op = op2.removeLast();
            if (op == '+') {
                res += operands.removeLast();
            } else {
                res -= operands.removeLast();
            }
        }
        return res;
    }
}
