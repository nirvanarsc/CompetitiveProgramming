package medium;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_98 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        return (low == null || node.val > low) && (high == null || node.val < high)
               && helper(node.left, low, node.val)
               && helper(node.right, node.val, high);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        final Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null, curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                if (prev != null && curr.val <= prev.val) { return false; }
                prev = curr;
                curr = curr.right;
            }
        }

        return true;
    }
}
