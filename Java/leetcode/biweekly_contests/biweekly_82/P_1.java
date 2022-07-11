package leetcode.biweekly_contests.biweekly_82;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_1 {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) & evaluateTree(root.right);
        }
    }
}
