package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int left = f(root.left);
        final int right = f(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }
        return (1 << right) + countNodes(root.left);
    }

    private static int f(TreeNode node) {
        int res = 0;
        while (node != null) {
            node = node.left;
            res++;
        }
        return res;
    }
}
