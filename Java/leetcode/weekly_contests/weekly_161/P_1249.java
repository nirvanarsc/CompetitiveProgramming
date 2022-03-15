package leetcode.weekly_contests.weekly_161;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1249 {

    public String minRemoveToMakeValidStack(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final boolean[] banned = new boolean[n];
        final int[] stack = new int[n];
        int stackIdx = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] == '(') {
                stack[stackIdx++] = i;
            } else if (w[i] == ')') {
                if (stackIdx > 0) {
                    stackIdx--;
                } else {
                    banned[i] = true;
                }
            }
        }
        for (int i = 0; i < stackIdx; i++) {
            banned[stack[i]] = true;
        }
        final StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (banned[i]) {
                continue;
            }
            res.append(w[i]);
        }
        return res.toString();
    }

    public String minRemoveToMakeValid(String s) {
        final Deque<Character> dq = new ArrayDeque<>();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                dq.addFirst('(');
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    dq.addFirst(')');
                    open--;
                }
            } else {
                dq.addFirst(c);
            }
        }
        final Deque<Character> res = new ArrayDeque<>();
        open = 0;
        while (!dq.isEmpty()) {
            final char c = dq.removeFirst();
            if (c == '(') {
                if (open > 0) {
                    res.addFirst('(');
                    open--;
                }
            } else if (c == ')') {
                res.addFirst(')');
                open++;
            } else {
                res.addFirst(c);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.removeFirst());
        }
        return sb.toString();
    }
}
