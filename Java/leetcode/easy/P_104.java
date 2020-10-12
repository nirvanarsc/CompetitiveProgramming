package leetcode.easy;

import utils.DataStructures.TreeNode;

public class P_104 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0
                            : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
