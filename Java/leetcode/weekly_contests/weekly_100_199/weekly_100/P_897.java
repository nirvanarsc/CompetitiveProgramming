package leetcode.weekly_contests.weekly_100_199.weekly_100;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_897 {

    public TreeNode increasingBSTOld(TreeNode root) {
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

    public TreeNode increasingBST(TreeNode root) {
        return dfs(root)[0];
    }

    private static TreeNode[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode[] left = dfs(root.left);
        if (left != null) {
            root.left = null;
            left[1].right = root;
        }
        final TreeNode[] right = dfs(root.right);
        if (right != null) {
            root.right = right[0];
        }
        final TreeNode[] res = new TreeNode[2];
        res[0] = (left != null) ? left[0] : root;
        res[1] = (right != null) ? right[1] : root;
        return res;
    }
}
