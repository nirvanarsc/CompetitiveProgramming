package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_114 {

    public void flatten(TreeNode root) {
        helper(root, null);
    }

    private static TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        return root;
    }

    public void flattenIterative(TreeNode root) {
        final Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.addFirst(root);
        }
        while (!stack.isEmpty()) {
            final TreeNode curr = stack.removeFirst();
            if (curr.right != null) {
                stack.addFirst(curr.right);
            }
            if (curr.left != null) {
                stack.addFirst(curr.left);
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peekFirst();
            }
            curr.left = null;
        }
    }
}
