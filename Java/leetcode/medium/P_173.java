package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_173 {

    class BSTIterator {
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
}
