package leetcode.weekly_contests.weekly_79;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_814 {

    public TreeNode pruneTree(TreeNode root) {
        final boolean res = dfs(root);
        return res ? root : null;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        final boolean left = dfs(root.left);
        final boolean right = dfs(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return left || right || root.val == 1;
    }

    public TreeNode pruneTreeR(TreeNode root) {
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.right == null && root.left == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
