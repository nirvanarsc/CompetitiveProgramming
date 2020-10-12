package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int left = getHeight(root.left);
        final int right = getHeight(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }
        return (1 << right) + countNodes(root.left);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getHeight(node.left);
    }

    public int countNodesOld(TreeNode root) {
        final int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h - 1 ? (1 << h) + countNodesOld(root.right)
                                           : (1 << h - 1) + countNodesOld(root.left);
    }

    private static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
