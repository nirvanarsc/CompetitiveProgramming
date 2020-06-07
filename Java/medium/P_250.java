package medium;

import utils.DataStructures.TreeNode;

public class P_250 {

    int count;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean isUnival = true;
        if (node.left != null) {
            isUnival = dfs(node.left) && node.left.val == node.val;
        }
        if (node.right != null) {
            isUnival &= dfs(node.right) && node.right.val == node.val;
        }
        if (isUnival) {
            count++;
        }
        return isUnival;
    }
}
