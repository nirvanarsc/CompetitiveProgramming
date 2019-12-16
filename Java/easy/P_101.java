package easy;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_101 {

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private static boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) { return true; }
        final Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root.left);
        stack.addFirst(root.right);
        while (!stack.isEmpty()) {
            final TreeNode n1 = stack.removeFirst();
            final TreeNode n2 = stack.removeFirst();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}
