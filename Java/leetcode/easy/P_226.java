package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
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
