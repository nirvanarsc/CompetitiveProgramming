package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_224 {

    public int calculateImproved(String s) {
        final Deque<Integer> dq = new ArrayDeque<>(Collections.singletonList(1));
        final char[] w = s.toCharArray();
        int res = 0;
        int sign = 1;
        int num = 0;
        for (char c : w) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * num;
                sign = dq.getFirst() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                dq.addFirst(sign);
            } else if (c == ')') {
                dq.removeFirst();
            }
        }
        res += sign * num;
        return res;
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
