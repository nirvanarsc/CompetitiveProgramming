package easy;

import utils.DataStructures.TreeNode;

public class P_965 {

    public boolean isUnivalTree(TreeNode root) {
        return isNodeUnival(root, root.val);
    }

    public boolean isNodeUnival(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && isNodeUnival(node.left, val) && isNodeUnival(node.right, val);
    }
}
