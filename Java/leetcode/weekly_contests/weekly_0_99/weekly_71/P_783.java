package leetcode.weekly_contests.weekly_0_99.weekly_71;

import utils.DataStructures.TreeNode;

public class P_783 {

    int res = (int) 1e9;
    int prev = (int) 1e9;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        res = Math.min(res, Math.abs(prev - node.val));
        prev = node.val;
        dfs(node.right);
    }
}
