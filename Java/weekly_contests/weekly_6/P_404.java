package weekly_contests.weekly_6;

import utils.DataStructures.TreeNode;

public class P_404 {

    int res;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        dfs(root.right);
    }
}


