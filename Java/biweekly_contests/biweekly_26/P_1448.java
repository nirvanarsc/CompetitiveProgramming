package biweekly_contests.biweekly_26;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_1448 {

    static class MaxStack {
        Deque<Integer> stack;
        Deque<Integer> maxStack;

        MaxStack() {
            stack = new ArrayDeque<>();
            maxStack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (maxStack.isEmpty() || x >= maxStack.getFirst()) {
                maxStack.addFirst(x);
            }
            stack.push(x);
        }

        public int pop() {
            if (maxStack.getFirst().equals(stack.getFirst())) {
                maxStack.removeFirst();
            }
            return stack.removeFirst();
        }

        public int peek() {
            return stack.getFirst();
        }

        public int peekMax() {
            return maxStack.getFirst();
        }
    }

    public int goodNodes(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, res, new MaxStack());
        return res[0];
    }

    private static void dfs(TreeNode node, int[] res, MaxStack path) {
        if (node == null) {
            return;
        }
        path.push(node.val);
        if (node.val == path.peekMax()) {
            res[0]++;
        }
        dfs(node.left, res, path);
        dfs(node.right, res, path);
        path.pop();
    }
}
