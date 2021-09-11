package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_224 {

    public int calculateImproved(String s) {
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singletonList(1));
        final char[] chars = s.toCharArray();
        int result = 0;
        int sign = 1;
        int num = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.getFirst() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                stack.addFirst(sign);
            } else if (c == ')') {
                stack.removeFirst();
            }
        }
        result += sign * num;
        return result;
    }

    public int calculate(String s) {
        final Deque<Deque<Integer>> terms = new ArrayDeque<>(Collections.singletonList(new ArrayDeque<>()));
        final Deque<Deque<Character>> signs = new ArrayDeque<>(Collections.singletonList(new ArrayDeque<>()));
        final char[] chars = s.toCharArray();
        int idx = 0;
        while (idx < chars.length) {
            if (chars[idx] == '(') {
                terms.addFirst(new ArrayDeque<>());
                signs.addFirst(new ArrayDeque<>());
            } else if (Character.isDigit(chars[idx])) {
                int num = chars[idx] - '0';
                while (++idx < chars.length && Character.isDigit(chars[idx])) {
                    num *= 10;
                    num += chars[idx] - '0';
                }
                idx--;
                terms.getFirst().offerLast(num);
            } else if (chars[idx] == '+' || chars[idx] == '-') {
                signs.getFirst().offerLast(chars[idx]);
            } else if (chars[idx] == ')') {
                final int res = evaluate(terms, signs);
                terms.removeFirst();
                signs.removeFirst();
                terms.getFirst().offerLast(res);
            }
            idx++;
        }
        return evaluate(terms, signs);
    }

    private static int evaluate(Deque<Deque<Integer>> terms, Deque<Deque<Character>> signs) {
        int res = terms.getFirst().removeFirst();
        while (!terms.getFirst().isEmpty()) {
            if (signs.getFirst().removeFirst() == '+') {
                res += terms.getFirst().removeFirst();
            } else {
                res -= terms.getFirst().removeFirst();
            }
        }
        return res;
    }
}
