package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private static boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        return (low == null || low < node.val)
               && (high == null || node.val < high)
               && dfs(node.left, low, node.val)
               && dfs(node.right, node.val, high);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
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
