package leetcode.easy;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_226 {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private static TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        final TreeNode l = dfs(node.left);
        final TreeNode r = dfs(node.right);
        return new TreeNode(node.val, r, l);
    }
}
