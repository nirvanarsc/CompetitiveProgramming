package leetcode.weekly_contests.weekly_24;

import utils.DataStructures.TreeNode;

public class P_538 {

    int sum;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        final int t = node.val;
        node.val += sum;
        sum += t;
        dfs(node.left);
    }
}
