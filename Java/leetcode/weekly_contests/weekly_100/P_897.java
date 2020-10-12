package leetcode.weekly_contests.weekly_100;

import utils.DataStructures.TreeNode;

public class P_897 {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        final TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, prev);
        return res;
    }
}
