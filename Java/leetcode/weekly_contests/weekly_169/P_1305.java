package leetcode.weekly_contests.weekly_169;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1305 {

    private static class BSTIterator {
        private final Deque<TreeNode> stack;

        BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            goLeft(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int peek() {
            return stack.element().val;
        }

        public int next() {
            final TreeNode node = stack.removeFirst();
            goLeft(node.right);
            return node.val;
        }

        private void goLeft(TreeNode curr) {
            while (curr != null) {
                stack.addFirst(curr);
                curr = curr.left;
            }
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        final BSTIterator left = new BSTIterator(root1);
        final BSTIterator right = new BSTIterator(root2);
        final List<Integer> res = new ArrayList<>();
        while (left.hasNext() && right.hasNext()) {
            if (left.peek() < right.peek()) {
                res.add(left.next());
            } else {
                res.add(right.next());
            }
        }
        while (left.hasNext()) {
            res.add(left.next());
        }
        while (right.hasNext()) {
            res.add(right.next());
        }
        return res;
    }
}
