package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_226 {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private static TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        final TreeNode l = dfs(node.left);
        final TreeNode r = dfs(node.right);
        return new TreeNode(node.val, r, l);
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offerLast(root);
        }
        while (!queue.isEmpty()) {
            final TreeNode node = queue.removeFirst();
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) { queue.offerLast(node.left); }
            if (node.right != null) { queue.offerLast(node.right); }
        }
        return root;
    }
}
