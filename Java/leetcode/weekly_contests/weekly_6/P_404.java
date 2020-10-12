package leetcode.weekly_contests.weekly_6;

import utils.DataStructures.TreeNode;

public class P_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = dfs(node.left) + dfs(node.right);
        if (isLeftLeaf(node)) {
            sum += node.left.val;
        }
        return sum;
    }

    private static boolean isLeftLeaf(TreeNode node) {
        return node.left != null && node.left.left == null && node.left.right == null;
    }
}


