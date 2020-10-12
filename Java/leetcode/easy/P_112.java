package leetcode.easy;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    boolean res;

    public boolean hasPathSumInOrder(TreeNode root, int sum) {
        dfs(root, sum, new int[] { 0 });
        return res;
    }

    private void dfs(TreeNode node, int sum, int[] path) {
        if (node == null) {
            return;
        }
        path[0] += node.val;
        dfs(node.left, sum, path);
        if (node.left == null && node.right == null) {
            res |= path[0] == sum;
        }
        dfs(node.right, sum, path);
        path[0] -= node.val;
    }
}
