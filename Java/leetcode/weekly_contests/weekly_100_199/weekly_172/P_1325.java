package leetcode.weekly_contests.weekly_100_199.weekly_172;

import utils.DataStructures.TreeNode;

public class P_1325 {

    public TreeNode removeLeafNodesSimplified(TreeNode root, int target) {
        if (root.left != null) { root.left = removeLeafNodes(root.left, target); }
        if (root.right != null) { root.right = removeLeafNodes(root.right, target); }
        return root.left == root.right && root.val == target ? null : root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        while (helper(root, target, new int[] { 0 })[0] > 0) { }
        return root.left == null && root.right == null && root.val == target ? null : root;
    }

    private static int[] helper(TreeNode node, int target, int[] res) {
        if (node == null) {
            return res;
        }
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null && node.left.val == target) {
                res[0]++;
                node.left = null;
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null && node.right.val == target) {
                res[0]++;
                node.right = null;
            }
        }
        helper(node.left, target, res);
        helper(node.right, target, res);
        return res;
    }
}
