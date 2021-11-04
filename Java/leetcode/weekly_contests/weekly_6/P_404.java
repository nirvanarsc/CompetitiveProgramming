package leetcode.weekly_contests.weekly_6;

import utils.DataStructures.TreeNode;

public class P_404 {

    static int res;

    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        dfs(root, false);
        return res;
    }

    private static void dfs(TreeNode node, boolean add) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (add) {
                res += node.val;
            }
        }
        //noinspection ConstantConditions
        dfs(node.left, true);
        dfs(node.right, false);
    }
}


