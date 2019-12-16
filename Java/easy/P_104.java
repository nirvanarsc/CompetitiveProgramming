package easy;

import utils.DataStructures.TreeNode;

public class P_104 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : helper(root, 1);
    }

    private static int helper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));
    }
}
