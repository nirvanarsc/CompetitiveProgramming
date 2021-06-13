package leetcode.biweekly_contests.biweekly_54;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    private static final class Tree {
        private char op = '*';
        private int val = -1;
        private Tree left, right;

        private Tree(char op) {
            this.op = op;
        }

        private Tree(int val) {
            this.val = val;
        }
    }

    private int idx = -1;

    public int minOperationsToFlip(String expression) {
        idx = 0;
        final Deque<Tree> dq = new ArrayDeque<>();
        build(expression, dq);
        final int[] res = dfs(dq.removeFirst());
        return Math.abs(res[0] - res[1]);
    }

    private static int[] dfs(Tree node) {
        if (node.val != -1) {
            return new int[] { node.val, 1 ^ node.val };
        }
        final int[] left = dfs(node.left);
        final int[] right = dfs(node.right);
        final int zero;
        final int one;
        if (node.op == '&') {
            zero = Math.min(left[0], right[0]);
            one = Math.min(left[1] + right[1], 1 + Math.min(left[1], right[1]));
        } else {
            zero = Math.min(left[0] + right[0], 1 + Math.min(left[0], right[0]));
            one = Math.min(left[1], right[1]);
        }
        return new int[] { zero, one };
    }

    private void build(String s, Deque<Tree> dq) {
        if (idx == s.length()) {
            return;
        }
        final char ch = s.charAt(idx++);
        if (ch == '0' || ch == '1') {
            add(dq, new Tree(ch - '0'));
        } else if (ch == '(') {
            final Deque<Tree> tmp = new ArrayDeque<>();
            build(s, tmp);
            add(dq, tmp.removeFirst());
        } else if (ch == '&' || ch == '|') {
            final Tree node = new Tree(ch);
            node.left = dq.removeFirst();
            dq.addFirst(node);
        } else {
            return;
        }
        build(s, dq);
    }

    private static void add(Deque<Tree> dq, Tree node) {
        if (dq.isEmpty()) {
            dq.addFirst(node);
        } else {
            dq.getFirst().right = node;
        }
    }
}
