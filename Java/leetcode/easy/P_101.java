package leetcode.easy;

import utils.DataStructures.TreeNode;

public class P_101 {

    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
