package leetcode.hard;

import utils.DataStructures.TreeNode;

public class P_99 {

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        dfs(root);
        final int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
        dfs(node.right);
    }
}
