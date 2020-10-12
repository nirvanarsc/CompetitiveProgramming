package leetcode.hard;

import utils.DataStructures.TreeNode;

public class P_99 {

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        traverse(root);
        final int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (prev != null && node.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
        traverse(node.right);
    }
}
