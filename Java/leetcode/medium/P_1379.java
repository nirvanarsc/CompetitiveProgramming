package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_1379 {

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        final TreeNode left = getTargetCopy(original.left, cloned.left, target);
        final TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left == null ? right : left;
    }
}
